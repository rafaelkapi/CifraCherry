package com.cactus.cifracherry.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cactus.cifracherry.R
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.Musician
import com.cactus.cifracherry.data.repository.LocalDataSource
import com.cactus.cifracherry.databinding.ActivityHomeBinding
import com.cactus.cifracherry.presentation.album.AlbumActivity
import com.cactus.cifracherry.presentation.home.listalbuns.AlbumAdapter
import com.cactus.cifracherry.presentation.home.listcard.CardViewModel
import com.cactus.cifracherry.presentation.home.listcard.CardsAdapter
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel = HomeViewModel.ViewModelFactory(LocalDataSource())
        .create(HomeViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)



        viewModel.callSetupCardAdapter = { setupRecyclerViewCards(it) }
        viewModel.callSetupAlbumAdapter = { setupRecyclerViewAlbum() }
        viewModel.callUpdateRecyclerCard = { updateRecyclerCards(it) }
        viewModel.callOpenAlbum = {openAlbum(it)}
        viewModel.setup()
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

    }

    private fun setupRecyclerViewCards(list: List<Musician>) {
        rv_cards.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_cards.adapter = CardsAdapter(
            list,
            { card: CardViewModel? -> viewModel.onClickMark(card) },
            { card: CardViewModel? -> viewModel.onClickDelete(card) }
        )
    }

    private fun updateRecyclerCards(position: Int) {
        rv_cards.adapter?.notifyItemChanged(position)
    }

    private fun setupRecyclerViewAlbum() {
        rv_albums.layoutManager = GridLayoutManager(this, 3)
        rv_albums.adapter = AlbumAdapter { album -> viewModel.onClickAlbum(album) }
    }

    private fun openAlbum(album: Album?) {
        val intent = Intent(this, AlbumActivity::class.java).apply {
            putExtra("album", album)
        }
        startActivity(intent)
    }


}