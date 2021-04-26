package com.cactus.cifracherry.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cactus.cifracherry.data.MusiciansResult
import com.cactus.cifracherry.data.model.Musician
import com.cactus.cifracherry.data.repository.HomeRepository
import java.lang.IllegalArgumentException

class HomeViewModel(val dataSource: HomeRepository) : ViewModel() {

    var callAdapterListCard: ((List<Musician>)->Unit)? = null
//    val listMusiLiveData: MutableLiveData<List<Musician>> = MutableLiveData()
    private var listMusician: List<Musician> = listOf()

    fun setup() {
        taskLoadCards()
    }


    private fun taskLoadCards() {
        getMusicians()
        callAdapterListCard?.invoke(listMusician)

    }

    fun getMusicians() {
        dataSource.getMusicians { result: MusiciansResult ->
            when(result) {
                is MusiciansResult.Success -> {
                    listMusician = result.musicians
                }
                is MusiciansResult.Error -> { }

            }
        }
    }

    class ViewModelFactory(val dataSource: HomeRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(dataSource) as T
            }
            throw IllegalArgumentException("Unknow ViewModel class")
        }
    }


    fun onClickMark(user: Musician?) {}
    fun onClickDelete(user: Musician?) {}
}