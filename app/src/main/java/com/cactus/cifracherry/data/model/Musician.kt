package com.cactus.cifracherry.data.model

import androidx.databinding.ObservableBoolean
import com.cactus.cifracherry.common.Enums
import com.cactus.cifracherry.presentation.home.listcard.CardViewModel

data class Musician (
    var id: String? = null,
    val name: String? = null,
    var specialty: String? = null,
    var urlPhoto: String? = null,
    var albums: List<Album>? = null,
    var displayControlCard: DisplayControlCard? = null
)

data class DisplayControlCard (
    var showTypeCard: Enums? = null,
    var position: Int? = null
    )