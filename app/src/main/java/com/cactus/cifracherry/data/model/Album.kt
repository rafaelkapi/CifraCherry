package com.cactus.cifracherry.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
    var name: String? = null,
    var urlImage: String? = null,
    var lisMusic: List<Music>? = null
) : Parcelable