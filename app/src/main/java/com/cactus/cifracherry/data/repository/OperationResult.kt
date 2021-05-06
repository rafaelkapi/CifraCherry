package com.cactus.cifracherry.data.repository

sealed class OperationResult {
    class Success<T>(val list: List<T>) : OperationResult() // Extendo a própria classe para trabalhar com when
    class Error(val error: String?) : OperationResult()
 }