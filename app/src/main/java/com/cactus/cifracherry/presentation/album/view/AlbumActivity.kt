package com.cactus.cifracherry.presentation.album.view

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.cactus.cifracherry.R
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.databinding.ActivityAlbumBinding
import com.cactus.cifracherry.presentation.album.AlbumViewModel

class AlbumActivity : AppCompatActivity() {

    private lateinit var viewModel: AlbumViewModel

    var uri: Uri? = null

    lateinit var startForResult: ActivityResultLauncher<Intent>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        viewModel.callStartAlbumFragment = { startAlbumFragment() }
        viewModel.callStartCifraFragment = { startCifraFragment() }
        viewModel.callFilePickerIntent = { filePickerIntent() }

        val album = intent.extras?.getParcelable<Album>("album")
        if (album != null) {
            viewModel.setAlbum(album)
        }

        val binding =
            DataBindingUtil.setContentView<ActivityAlbumBinding>(this, R.layout.activity_album)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this


        viewModel.setup()

         startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                viewModel.starForActivityResult(result.data?.data)
            }
        }

    }



    fun startAlbumFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.my_container, AlbumFragment.newInstance())
            .commit()
    }

    fun startCifraFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_container, CifraFragment.newInstance())
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }

    fun filePickerIntent() {

       val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            .apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "text/plain" // mime
            }
        startForResult.launch(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


    companion object {
        const val REQ_CODE_IMPORT = 45124
    }
}