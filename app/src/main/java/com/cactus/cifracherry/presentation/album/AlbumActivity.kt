package com.cactus.cifracherry.presentation.album

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.cactus.cifracherry.R
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.databinding.ActivityAlbumBinding
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity() {

    private lateinit var viewModel: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        viewModel.callStartAlbumFragment = {startAlbumFragment()}

        val album = intent.extras?.getParcelable<Album>("album")
        if (album != null) {
            viewModel.setAlbum(album)
        }

        val binding =
            DataBindingUtil.setContentView<ActivityAlbumBinding>(this, R.layout.activity_album)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this


        viewModel.setup()

    }

    fun startAlbumFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.my_container, AlbumFragment.newInstance())
            .commit()
    }
}