package com.cactus.cifracherry.presentation.album

import android.net.Uri
import android.util.Log
import androidx.lifecycle.*
import com.cactus.cifracherry.common.MediaHelper
import com.cactus.cifracherry.common.SupportMedia
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.Music

class AlbumViewModel : ViewModel() {

    private var album: Album? = null
    private val mediaHelper: SupportMedia = MediaHelper()

    private val _listMusics: MutableLiveData<List<Music>> = MutableLiveData()
    val listMusic: LiveData<List<Music>>
        get() = _listMusics

    private val _urlPhoto: MutableLiveData<String> = MutableLiveData()
    val urlPhoto: LiveData<String>
        get() = _urlPhoto

    private val _name: MutableLiveData<String> = MutableLiveData()
    val name: LiveData<String>
        get() = _name

    private val _cifra: MutableLiveData<String> = MutableLiveData()
    val cifra: LiveData<String>
        get() = _cifra

    var callStartAlbumFragment: (() -> Unit)? = null
    var callStartCifraFragment: (() -> Unit)? = null
    var callFilePickerIntent: (() -> Unit)? = null


    fun setup() {
        callStartAlbumFragment?.invoke()
    }

    fun onClickAddCifra() {
        callFilePickerIntent?.invoke()
    }

    fun starForActivityResult(uri: Uri?) {
        if (uri != null) {
            val newPathUri = mediaHelper.saveCifra(uri) ?: return
            _cifra.value = mediaHelper.read(newPathUri).toString()
            callStartCifraFragment?.invoke()
        }
    }

    fun onClickMusic(music: Music?) {
        _cifra.value = music?.cifra ?: "Sem texto"
        callStartCifraFragment?.invoke()
    }

    fun setAlbum(album: Album) {
        this.album = album
        _name.value = album.name
        _urlPhoto.value = album.urlImage
        if (album.lisMusic != null) {
            _listMusics.value = album.lisMusic
        } else _listMusics.value = listOf(emptyMusic())
    }

    fun emptyMusic(): Music {
        return Music(null, null, null, "Cifra não selecionada", null)
    }
}