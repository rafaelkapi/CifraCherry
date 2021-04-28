package com.cactus.cifracherry.data.repository

import com.cactus.cifracherry.data.OperationResult
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.DisplayControlCard
import com.cactus.cifracherry.data.model.Musician

class LocalDataSource : HomeRepository {

    private val listMusicians = listOf<Musician>(
        Musician(null,"Logo",null,null, DisplayControlCard(false,false,true)),
        Musician(null, "Roberto Carlos", "Cantor", "O cara é o rei fio, sem mais"),
        Musician(null, "Derci Gonçalves", "Cantora", "Pegou geral e vai pegar você!"),
        Musician(null, "Slash", "Guitarrista", "O cara é fera memo"),
        Musician(null, "Zézinho", "Tocador de Cuíca", "Esse é o rei do pisero, adestrador profissional de calangos nordestinos")
    )

    private val listAlbums = listOf<Album>(
        Album("Sertanejo",null),
        Album("Pop",null),
        Album("Funk",null),
        Album("Forrozin",null),
        Album("Modão",null),
        Album("Rock Nacional",null),
        Album("Internacionais",null),
        Album("Agitadas",null)
    )



    override fun getMusicians(operationResultCallback: (result: OperationResult)-> Unit){
        operationResultCallback(OperationResult.Success(listMusicians))
    }

    override fun getAlbums(operationResultCallback: (result: OperationResult) -> Unit) {
        operationResultCallback(OperationResult.Success(listAlbums))
    }
}