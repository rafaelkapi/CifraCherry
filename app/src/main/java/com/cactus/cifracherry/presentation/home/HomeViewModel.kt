package com.cactus.cifracherry.presentation.home

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cactus.cifracherry.data.OperationResult
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.Musician
import com.cactus.cifracherry.data.repository.HomeRepository
import com.cactus.cifracherry.presentation.home.listcard.CardViewModel
import com.squareup.picasso.Picasso
import java.lang.IllegalArgumentException

class HomeViewModel(val dataSource: HomeRepository) : ViewModel() {

    var callSetupCardAdapter: ((List<Musician>) -> Unit)? = null
    var callSetupAlbumAdapter: (() -> Unit)? = null
    var callUpdateRecyclerCard: ((Int) -> Unit)? = null

    private val _listAlbum: MutableLiveData<List<Album>> = MutableLiveData()
    val listAlbum: LiveData<List<Album>>
        get() = _listAlbum

    private val _nameMark: MutableLiveData<String> = MutableLiveData()
    val nameMark: LiveData<String>
        get() = _nameMark

    private var listMusician: List<Musician> = listOf()


    private var oldCArd: CardViewModel? = null


    fun setup() {
        taskLoadCards()
        taskLoadAlbums()
    }

    private fun taskLoadCards() {
        getMusicians()
        callSetupCardAdapter?.invoke(listMusician)

    }

    private fun taskLoadAlbums() {
        _listAlbum.value = listMusician[1].albums
        _nameMark.value = listMusician[1].name
        callSetupAlbumAdapter?.invoke()
    }

    fun getMusicians() {
        dataSource.getMusicians { result: OperationResult ->
            when (result) {
                is OperationResult.Success<*> -> {
                    listMusician = result.list as List<Musician>
                }
                is OperationResult.Error -> {
                }
            }
        }
    }



    class ViewModelFactory(val dataSource: HomeRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(dataSource) as T
            }
            throw IllegalArgumentException("Unknow ViewModel class")
        }
    }

    fun onClickMark(card: CardViewModel?) {
        Log.i("Teste button", "mark musician ${card?.user?.name}")
        markCard(card)
        _listAlbum.value = card?.user?.albums ?: emptyList()
        _nameMark.value = card?.user?.name ?: ""
    }

    fun onClickDelete(card: CardViewModel?) {}
    fun onClickAlbum(album: Album?) {}



    fun markCard(card: CardViewModel?) {
        if (oldCArd != card) {
            card?.isMarked?.set(true)
            oldCArd?.isMarked?.set(false)
            oldCArd = card
        }
    }


}