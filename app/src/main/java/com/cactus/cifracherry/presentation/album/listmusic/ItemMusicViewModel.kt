package com.cactus.cifracherry.presentation.album.listmusic

import androidx.databinding.ObservableChar
import androidx.databinding.ObservableField
import com.cactus.cifracherry.common.LambdaClickMusic
import com.cactus.cifracherry.data.model.Music

class ItemMusicViewModel {

    var music: Music? = null

    var name: ObservableField<String> = ObservableField()
    var author: ObservableField<String> = ObservableField()
    var tone: ObservableField<String> = ObservableField()
    var urlPhoto: ObservableField<String> = ObservableField()


    var onClickMusic: LambdaClickMusic? = null

    fun onClick() {
        onClickMusic?.invoke(music)
    }

    fun setItem(music: Music?) {
        this.music = music
        name.set(music?.name)
        author.set(music?.author)
        tone.set(music?.tone)
        urlPhoto.set(music?.urlPhoto)
    }

}