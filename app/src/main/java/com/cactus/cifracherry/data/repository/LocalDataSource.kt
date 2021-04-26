package com.cactus.cifracherry.data.repository

import com.cactus.cifracherry.data.MusiciansResult
import com.cactus.cifracherry.data.model.Musician

class LocalDataSource : HomeRepository {

    val listMusicians = listOf<Musician>(
        Musician(null, "Roberto Carlos", "Cantor", "O cara é o rei fio, sem mais"),
        Musician(null, "Derci Gonçalves", "Cantora", "Pegou geral e vai pegar você!"),
        Musician(null, "Slash", "Guitarrista", "O cara é fera memo"),
        Musician(null, "Zézinho", "Tocador de Cuíca", "Esse é o rei do pisero, adestrador profissional de calangos nordestinos")
    )

    override fun getMusicians(musiciansResultCallback: (result: MusiciansResult)-> Unit){
        musiciansResultCallback(MusiciansResult.Success(listMusicians))
    }
}