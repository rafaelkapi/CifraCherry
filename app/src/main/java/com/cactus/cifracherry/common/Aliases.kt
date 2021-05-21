package com.cactus.cifracherry.common

import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.Music
import com.cactus.cifracherry.data.model.Musician
import com.cactus.cifracherry.presentation.album.listmusic.ItemMusicViewModel
import com.cactus.cifracherry.presentation.home.listcard.CardViewModel

typealias CallClickCard = (CardViewModel?)->Unit

typealias CallClickAlbum = (Album?)->Unit

typealias CallClickMusic = (Music?)->Unit

typealias CallMenuOptionsMusic = (edit: Boolean, itemMusic: ItemMusicViewModel)-> Unit