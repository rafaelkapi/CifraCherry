package com.cactus.cifracherry.data.repository

import com.cactus.cifracherry.data.MusiciansResult

interface HomeRepository {
    fun getMusicians(musiciansResultCallback: (result: MusiciansResult)-> Unit)
}