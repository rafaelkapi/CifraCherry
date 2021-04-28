package com.cactus.cifracherry.presentation.home.listcard

import com.cactus.cifracherry.common.FunClickMusician
import com.cactus.cifracherry.data.model.Musician

class CardViewModel {

    //dependencies
    var user: Musician? = null
    var marked = true
    var onClickButtonMark: FunClickMusician? = null
    var onClickButtonDelete: FunClickMusician? = null

    fun onClickMark() {
        onClickButtonMark?.invoke(user)
        showMark()

    }

    fun onClickDelete() {
        onClickButtonDelete?.invoke(user)
    }

    fun getName() = user?.name ?: ""

    fun getSpecialty() = user?.specialty ?: ""


    fun getUrlphoto() = user?.url ?: ""

    fun showLogo() : Boolean? {
        if (user?.displayControlCard != null) {
          return user?.displayControlCard?.showLogo
        }
        return false
    }

    fun showMusicianCard() : Boolean? {
        if (user?.displayControlCard != null) {
            return user?.displayControlCard?.showMusicianCard
        }
        return true
    }

    fun showAddCard() : Boolean? {
        if (user?.displayControlCard != null) {
            return user?.displayControlCard?.showAddCard
        }
        return false
    }


    fun showMark() {
       marked = !marked
    }

//        @BindingAdapter(value = ["setImageUrl"])
//        fun CircleImageView.bindImageUrl(url: String?) {
//            if (url != null && url.isNotBlank()) {
//
//                Picasso.get()
//                    .load(url)
//                    .into(this)
//            }
//        }


}