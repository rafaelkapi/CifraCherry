package com.cactus.cifracherry.data.repository

import android.content.ContentResolver
import android.content.Context
import android.content.res.Resources
import android.net.Uri
import com.cactus.cifracherry.R
import com.cactus.cifracherry.common.Enums
import com.cactus.cifracherry.data.OperationResult
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.DisplayControlCard
import com.cactus.cifracherry.data.model.Musician
import com.cactus.cifracherry.presentation.home.HomeActivity

class LocalDataSource : HomeRepository {


    private val listMusicians = listOf<Musician>(
        Musician(null, "Logo", null, null, null, DisplayControlCard(Enums.LOGO)),
        Musician(null, "Roberto Carlos", "Cantor", resourceUri("capa_album_aleatorias").toString()),
        Musician(null, "Derci Gonçalves", "Cantora", null),
        Musician(null, "Slash", "Guitarrista", null),
        Musician(null, "Zézinho", "Tocador de Cuíca", null)
    )


    private val listAlbums = listOf<Album>(
        Album("Sertanejo", resourceUri("capa_album_sertauniversitario").toString()),
        Album("Pop", resourceUri("capa_album_agitadas").toString()),
        Album("Forrozin", resourceUri("capa_album_calmas").toString()),
        Album("Clássicas", resourceUri("capa_album_classicas").toString()),
        Album("Rock Nacional", resourceUri("capa_album_rock").toString()),
        Album("Internacionais", resourceUri("capa_album_internacionais").toString()),
        Album("Agitadas", resourceUri("capa_album_aleatorias").toString())
    )


    override fun getMusicians(operationResultCallback: (result: OperationResult) -> Unit) {
        operationResultCallback(OperationResult.Success(listMusicians))
    }

    override fun getAlbums(operationResultCallback: (result: OperationResult) -> Unit) {
        operationResultCallback(OperationResult.Success(listAlbums))
    }

    fun resourceUri(drawable: String): Uri =
        Uri.parse("android.resource://com.cactus.cifracherry/drawable/${drawable}")
}