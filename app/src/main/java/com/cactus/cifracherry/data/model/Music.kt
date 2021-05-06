package com.cactus.cifracherry.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Music(
    var name: String? = null,
    var author: String? = null,
    var tone: String? = null,
    var urlPhoto: String? = null
) : Parcelable {
}