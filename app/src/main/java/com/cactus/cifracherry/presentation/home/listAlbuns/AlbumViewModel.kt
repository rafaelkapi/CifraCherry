package com.cactus.cifracherry.presentation.home.listAlbuns

import com.cactus.cifracherry.common.FunClickAlbum
import com.cactus.cifracherry.data.model.Album

class AlbumViewModel {

    var album: Album? = null
    var onClickAlbum: FunClickAlbum? = null

    fun onClickAlbum() {
        onClickAlbum?.invoke(album)
    }

    fun getName() = album?.name ?: ""

    fun getUrlPhoto() = album?.urlImage ?: ""

}