package com.cactus.cifracherry.presentation.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.Music

class AlbumViewModel : ViewModel() {

    private var album: Album? = null


    private val _listMusics: MutableLiveData<List<Music>> = MutableLiveData()
    val listAlbum: LiveData<List<Music>>
        get() = _listMusics

    private val _urlPhoto: MutableLiveData<String> = MutableLiveData()
    val urlPhoto: LiveData<String>
        get() = _urlPhoto

    private val _name: MutableLiveData<String> = MutableLiveData()
    val name: LiveData<String>
        get() = _name

    var callStartAlbumFragment: (() -> Unit)? = null
    var callSetupRecyclerViewMusic: (() -> Unit)? = null


    fun setup() {
        callStartAlbumFragment?.invoke()


    }



    fun onClickMusic(music: Music?){

    }

    fun setAlbum(album: Album) {
        this.album = album
        _name.value = album.name
        _urlPhoto.value = album.urlImage
        _listMusics.value = album.lisMusic
    }


}