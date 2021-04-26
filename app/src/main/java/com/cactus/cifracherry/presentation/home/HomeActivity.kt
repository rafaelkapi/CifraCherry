package com.cactus.cifracherry.presentation.home

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.cactus.cifracherry.R
import com.cactus.cifracherry.databinding.ActivityHomeBinding
import com.cactus.cifracherry.presentation.home.listcard.CardsAdapter
import com.cactus.cifracherry.data.model.Musician
import com.cactus.cifracherry.data.repository.LocalDataSource
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel = HomeViewModel.ViewModelFactory(LocalDataSource())
        .create(HomeViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)



        viewModel.callAdapterListCard = {setupRecyclerViewCards(it)}
        viewModel.setup()

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.rvCards
    }

    private fun setupRecyclerViewCards(list: List<Musician>) {
        rv_cards.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_cards.adapter = CardsAdapter(
            list,
            {user -> viewModel.onClickMark(user)},
            {user -> viewModel.onClickDelete(user)}
        )
    }


}