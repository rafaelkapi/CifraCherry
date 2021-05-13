package com.cactus.cifracherry.common

import android.content.ContentResolver
import android.net.Uri
import android.os.Environment
import android.util.Log
import com.cactus.cifracherry.R
import java.io.File
import java.io.FileOutputStream

class MediaHelper : SupportMedia {

    override fun builderUri(resourceId: Int): Uri {

        val context = MyApp.instance
        return Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .authority(context.resources.getResourcePackageName(resourceId))
            .appendPath(context.resources.getResourceTypeName(resourceId))
            .appendPath(context.resources.getResourceEntryName(resourceId))
            .build()
    }


    override fun readTxt(uri: Uri): String {

        val bufferedReader =
            MyApp.instance.resources.openRawResource(R.raw.saulofernandes).bufferedReader()
//        val bufferedReader = uri.toFile().bufferedReader()
//        val bufferedReader = FileReader(uri.toFile()).buffered()
//    val lineList = mutableListOf<String>()
        var inputString = ""

        bufferedReader.useLines { lines -> lines.forEach { inputString += "$it \n" } }

        return inputString
    }

    override fun saveCifra(uri: Uri): Uri? {

        val file = createTxtFile() ?: return null

        try {
            val inputStream = MyApp.instance.contentResolver.openInputStream(uri) ?: return null
            inputStream.use { input ->
                FileOutputStream(file).use { output ->
                    val buffer = ByteArray(1024)
                    var read: Int = input.read(buffer)
                    while (read > 0) {
                        output.write(buffer, 0, read)
                        read = input.read(buffer)
                    }
                    return Uri.fromFile(file)
                }
            }
        } catch (e: Exception) {
            file.deleteRecursively()
            throw e
        }
    }

    override fun read(uri: Uri): List<String> {
        val inputStream = MyApp.instance.contentResolver.openInputStream(uri) ?: return emptyList()
        val lineList = mutableListOf<String>()

        inputStream.bufferedReader().useLines {lines -> lines.forEach { lineList.add("$it \n")} }
        return lineList
    }


    fun createTxtFile(): File? {
        val storageDir = MyApp.instance.getExternalFilesDir(Environment.DIRECTORY_DCIM + "/Cifras/")
        if (storageDir != null && !storageDir.exists()) {
            if (!storageDir.mkdirs()) {
                Log.d("Teste", "Failed to create directory")
                return null
            }
        }
        return File(storageDir?.path + ".txt")
    }

}

interface SupportMedia {
    fun builderUri(resourceId: Int): Uri
    fun readTxt(path: Uri): String
    fun saveCifra(uri: Uri): Uri?
    fun read(uri: Uri): List<String>
}







