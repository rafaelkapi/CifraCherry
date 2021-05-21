package com.cactus.cifracherry.presentation.album

import android.net.Uri
import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableList
import androidx.lifecycle.*
import com.cactus.cifracherry.R
import com.cactus.cifracherry.common.MediaHelper
import com.cactus.cifracherry.common.SupportMedia
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.Music
import com.cactus.cifracherry.presentation.album.listmusic.ItemMusicViewModel

class AlbumViewModel : ViewModel() {

    private var album: Album? = null
    private val mediaHelper: SupportMedia = MediaHelper()


    private val _listMusics: MutableLiveData<List<Music>> = MutableLiveData()
    val listMusics: LiveData<List<Music>>
        get() = _listMusics

    private val _itemDeleted: MutableLiveData<Int?> = MutableLiveData()
    val itemDeleted: LiveData<Int?>
        get() = _itemDeleted

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
    var callShowMenuEdit: (() -> Unit)? = null


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
        _itemDeleted.value = null
        callStartCifraFragment?.invoke()
    }

    fun menuOptionsMusic(edit: Boolean, itemMusic: ItemMusicViewModel) {
        val mediaHelper: SupportMedia = MediaHelper()
        if (edit) {
            callShowMenuEdit?.invoke()
//            itemMusic.apply {
//                name.set("Mudei aqui")
//                author.set("funfa caraaaai xãmaaa")
//                urlPhoto.set(mediaHelper.builderUri(R.drawable.capa_album_aleatorias).toString())
//            }
            // * * * *   Delete Music   * * * *
        } else deleteMusic(itemMusic)
    }

    fun deleteMusic(itemMusic: ItemMusicViewModel) {
        _itemDeleted.value = itemMusic.position
    }


    fun setAlbum(album: Album) {
        this.album = album
        _name.value = album.name
        _urlPhoto.value = album.urlImage
        if (album.lisMusic != null) {
            _listMusics.value = album.lisMusic as MutableList<Music>
        } else _listMusics.value = mutableListOf(emptyMusic())
        _itemDeleted.value = null
    }

    fun emptyMusic(): Music {
        return Music(null, null, null, "Cifra não selecionada", null)
    }
}