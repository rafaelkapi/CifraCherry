package com.cactus.cifracherry.data.repository

import android.net.Uri
import com.cactus.cifracherry.common.Enums
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.data.model.DisplayControlCard
import com.cactus.cifracherry.data.model.Music
import com.cactus.cifracherry.data.model.Musician

class LocalDataSource : HomeRepository {

    private val listMusic = listOf<Music>(
        Music("Lagrimas do céu","Carminho","C", resourceUri("capa_album_classicas").toString()),
        Music("Senhor do tempo","Charlie Brown","D#", resourceUri("capa_album_internacionais").toString()),
        Music("Tapão na Raba","Saia Rodada","A", resourceUri("capa_album_calmas").toString()),
        Music("Teto de Vidro","Pity","F#m", resourceUri("capa_album_rock").toString()),
        Music("Muriçoca","Agreste","D", resourceUri("capa_album_aleatorias").toString()),
        Music("Zuar e Beber","Trio Bravana","F#", resourceUri("capa_album_agitadas").toString()),
        Music("Pedras da minha rua","Carminho","E", resourceUri("capa_album_classicas").toString()),
    )

    private val listListMusic = mutableListOf<List<Music>>(
        listMusic.drop(2),
        listMusic.filterIndexed {index, _ -> index != (1 or 2)},
        listMusic - listMusic[2] - listMusic[3] - listMusic[3]
    )


    private val listAlbums = mutableListOf<Album>(
        Album("Sertanejo", resourceUri("capa_album_sertauniversitario").toString(), listMusic),
        Album("Pop", resourceUri("capa_album_agitadas").toString(),listListMusic[0]),
        Album("Forrozin", resourceUri("capa_album_calmas").toString(), listListMusic[1]),
        Album("Clássicas", resourceUri("capa_album_classicas").toString(), listListMusic[2]),
        Album("Rock Nacional", resourceUri("capa_album_rock").toString()),
        Album("Internacionais", resourceUri("capa_album_internacionais").toString()),
        Album("Agitadas", resourceUri("capa_album_aleatorias").toString())
    )


    private val listListAlbums = mutableListOf<List<Album>>(
        listAlbums.drop(2),
        listAlbums.filterIndexed {index, _ -> index != (1 or 2)},
        listAlbums - listAlbums[2] - listAlbums[3] - listAlbums[3]
    )






    private val listMusicians = listOf<Musician>(
        Musician(null, "Logo", null, null, null, DisplayControlCard(Enums.LOGO)),
        Musician(null, "Roberto Carlos", "Cantor",
            resourceUri("capa_album_aleatorias").toString(), listAlbums),
        Musician(null, "Derci Gonçalves", "Cantora", null, listListAlbums[1]),
        Musician(null, "Slash", "Guitarrista", null,listListAlbums[0]),
        Musician(null, "Zézinho", "Tocador de Cuíca", null,listListAlbums[2])
    )







    override fun getMusicians(operationResultCallback: (result: OperationResult) -> Unit) {
        operationResultCallback(OperationResult.Success(listMusicians))
    }

//    override fun getAlbums(operationResultCallback: (result: OperationResult) -> Unit) {
//        operationResultCallback(OperationResult.Success(listAlbums))
//    }

    fun resourceUri(drawable: String): Uri =
        Uri.parse("android.resource://com.cactus.cifracherry/drawable/${drawable}")
}