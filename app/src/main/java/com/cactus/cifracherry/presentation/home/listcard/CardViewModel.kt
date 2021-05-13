package com.cactus.cifracherry.presentation.home.listcard

import androidx.databinding.ObservableBoolean
import com.cactus.cifracherry.common.Enums
import com.cactus.cifracherry.common.FunClickCard
import com.cactus.cifracherry.data.model.Musician
import com.cactus.cifracherry.databinding.ItemCardBinding

class CardViewModel {



    //dependencies
    var user: Musician? = null
    var isMarked : ObservableBoolean = ObservableBoolean(false)
    var binding : ItemCardBinding? = null
    var onClickButtonMark: FunClickCard? = null
    var onClickButtonDelete: FunClickCard? = null

    fun onClickMark() {
        onClickButtonMark?.invoke(this)
    }

    fun initMark() {
        onClickButtonMark?.invoke(this)
    }


    fun onClickDelete() {
        onClickButtonDelete?.invoke(this)
    }

    fun getName() = user?.name ?: ""

    fun getSpecialty() = user?.specialty ?: ""

    fun getUrlphoto() = user?.urlPhoto ?: ""

    fun showLogo() : Boolean {
        if (user?.displayControlCard?.showTypeCard == Enums.LOGO) {
          return true
        }
        return false
    }

    fun showMusicianCard() : Boolean {
        if (user?.displayControlCard?.showTypeCard == Enums.MUSICIANCARD) {
            return true
        }
        return true
    }

    fun showAddCard() : Boolean {
        if (user?.displayControlCard?.showTypeCard == Enums.ADDCARD) {
            return true
        }
        return false
    }





}