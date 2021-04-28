package com.cactus.cifracherry.data.repository

import com.cactus.cifracherry.data.OperationResult

interface HomeRepository {
    fun getMusicians(operationResultCallback : (result: OperationResult)-> Unit)
    fun getAlbums(operationResultCallback: (result: OperationResult)-> Unit)
}