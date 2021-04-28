package com.cactus.cifracherry.data.model

data class Musician (
    var id: String? = null,
    val name: String? = null,
    var specialty: String? = null,
    var url: String? = null,
    var displayControlCard: DisplayControlCard? = null
)

data class DisplayControlCard (
    var showAddCard: Boolean = false,
    var showMusicianCard: Boolean = true,
    var showLogo: Boolean = false)