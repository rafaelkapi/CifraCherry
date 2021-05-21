package com.cactus.cifracherry.presentation.album.listmusic

import androidx.databinding.ObservableField
import com.cactus.cifracherry.common.CallClickMusic
import com.cactus.cifracherry.common.CallMenuOptionsMusic
import com.cactus.cifracherry.data.model.Music
import com.cactus.cifracherry.databinding.ItemMusicBinding

class ItemMusicViewModel {

    var music: Music? = null
    var position: Int? = null

    var name: ObservableField<String> = ObservableField()
    var author: ObservableField<String> = ObservableField()
    var tone: ObservableField<String> = ObservableField()
    var urlPhoto: ObservableField<String> = ObservableField()


    var onClickMusic: CallClickMusic? = null
    var menuOptionsMusic: CallMenuOptionsMusic? = null

    var binding: ItemMusicBinding? = null

    fun onClick() {
        onClickMusic?.invoke(music)
    }

    fun menuOptions(edit: Boolean) {

        binding.let {
            it?.itemMusicContainer?.transitionToStart()
        }
        menuOptionsMusic?.invoke(edit,this)
    }

    fun setItem(music: Music?) {
        this.music = music

        name.set(music?.name ?: "")

//        author.set(("Por ${music?.author}") ?: "")
//
//        if (music?.name != null) {
//            name.set(music.name)
//        } else name.set("")

        if (music?.author != null) {
            author.set("Por ${music.author}")
        } else author.set("")

        if (music?.tone != null) {
            tone.set("Tom: ${music.tone}")
        } else tone.set("")

        urlPhoto.set(music?.urlPhoto)
    }

}