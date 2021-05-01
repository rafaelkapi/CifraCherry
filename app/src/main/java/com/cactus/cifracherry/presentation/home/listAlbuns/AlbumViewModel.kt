package com.cactus.cifracherry.presentation.home.listAlbuns

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cactus.cifracherry.common.FunClickAlbum
import com.cactus.cifracherry.data.model.Album

class AlbumViewModel {

    var album: Album? = null
    var onClickAlbum: FunClickAlbum? = null

    fun onClickAlbum() {
        onClickAlbum?.invoke(album)
    }


//    private val _getName: MutableLiveData<String> = MutableLiveData()
//    val getName: LiveData<String>
//        get() = _getName
//
//    fun setName(name: String?) {
//        _getName.value = name
//        album?.name = name
//    }


    fun getUrlPhoto() = album?.urlImage ?: ""
    fun getName() = album?.name ?: ""

}