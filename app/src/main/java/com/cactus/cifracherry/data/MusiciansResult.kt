package com.cactus.cifracherry.data

import com.cactus.cifracherry.data.model.Musician

sealed class MusiciansResult {
    class Success(val musicians: List<Musician>) : MusiciansResult() // Extendo a própria classe para trabalhar com when
    class Error(val error: String?) : MusiciansResult()
 }