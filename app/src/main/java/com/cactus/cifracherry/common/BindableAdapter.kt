package com.cactus.cifracherry.common

interface BindableAdapter<T> {
    fun setData(items: List<T>)
    fun deleteItem(position: Int?)
    fun changedPositions(positions: Set<Int>)
}