package com.cactus.cifracherry.common

import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.Music
import com.cactus.cifracherry.data.model.Musician
import com.cactus.cifracherry.presentation.home.listcard.CardViewModel

typealias FunClickCard = (CardViewModel?)->Unit

typealias LambdaClickAlbum = (Album?)->Unit

typealias LambdaClickMusic = (Music?)->Unit