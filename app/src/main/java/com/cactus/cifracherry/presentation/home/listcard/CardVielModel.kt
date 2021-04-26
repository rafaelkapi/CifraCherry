package com.cactus.cifracherry.presentation.home.listcard

import androidx.databinding.BindingAdapter
import com.cactus.cifracherry.data.model.Musician
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CardVielModel {

    //dependencies
    var user: Musician? = null
    var marked = true
    var onClickButtonMark: ((Musician?) -> Unit)? = null
    var onClickButtonDelete: ((Musician?) -> Unit)? = null

    fun onClickMark() {
        onClickButtonMark?.invoke(user)
        showMark()

    }

    fun onClickDelete() {
        onClickButtonDelete?.invoke(user)
    }

    fun getName() = user?.name ?: ""

    fun getSpecialty() = user?.specialty ?: ""

    fun getDescription() = user?.description ?: ""

    fun getUrlphoto() = user?.url ?: ""


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