package com.cactus.cifracherry.presentation.home

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cactus.cifracherry.data.OperationResult
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.Musician
import com.cactus.cifracherry.data.repository.HomeRepository
import java.lang.IllegalArgumentException

class HomeViewModel(val dataSource: HomeRepository) : ViewModel() {

    var callSetupCardAdapter: ((List<Musician>)->Unit)? = null
    var callSetupAlbumAdapter: ((List<Album>)->Unit)? = null
//    val listMusiLiveData: MutableLiveData<List<Musician>> = MutableLiveData()
    private var listMusician: List<Musician> = listOf()
    private var listAlbums: List<Album> = listOf()

    companion object{
        @BindingAdapter("requestFocus")
        @JvmStatic fun View.requestFocus(requestFocus: Boolean){
                this.isFocusableInTouchMode = requestFocus
        }
    }

    fun setup() {
        taskLoadCards()
        taskLoadAlbums()
    }

    private fun taskLoadCards() {
        getMusicians()
        callSetupCardAdapter?.invoke(listMusician)
    }

    private fun taskLoadAlbums() {
        getAlbums()
        callSetupAlbumAdapter?.invoke(listAlbums)
    }

    fun getMusicians() {
        dataSource.getMusicians { result: OperationResult ->
            when(result) {
                is OperationResult.Success<*> -> {
                    listMusician = result.list as List<Musician>
                }
                is OperationResult.Error -> { }
            }
        }
    }

    fun getAlbums() {
        dataSource.getAlbums { result: OperationResult ->
            when(result) {
                is OperationResult.Success<*> -> {
                    listAlbums = result.list as List<Album>
                }
                is OperationResult.Error -> { }
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

    fun onClickMark(user: Musician?) {}
    fun onClickDelete(user: Musician?) {}
    fun onClickAlbum(album: Album?) {}
}