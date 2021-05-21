package com.cactus.cifracherry.presentation.home.listalbuns

import com.cactus.cifracherry.common.CallClickAlbum
import com.cactus.cifracherry.data.model.Album

class ItemAlbumViewModel {

    var album: Album? = null
    var onClickAlbum: CallClickAlbum? = null

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