package com.cactus.cifracherry.data.repository

interface HomeRepository {
    fun getMusicians(operationResultCallback : (result: OperationResult)-> Unit)
}