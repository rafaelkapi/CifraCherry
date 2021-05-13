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
    var onClickMore: LambdaClickMusic? = null

    fun onClick() {
        onClickMusic?.invoke(music)
    }

    fun onClickMore() {
        onClickMore?.invoke(music)
    }

    fun setItem(music: Music?) {
        this.music = music

        if (music?.name != null) {
            name.set(music?.name)
        } else name.set("")

        if (music?.author != null) {
            author.set("Por ${music?.author}")
        } else author.set("")

        if (music?.tone != null) {
            tone.set("Tom: ${music?.tone}")
        } else tone.set("")

        urlPhoto.set(music?.urlPhoto)
    }

}