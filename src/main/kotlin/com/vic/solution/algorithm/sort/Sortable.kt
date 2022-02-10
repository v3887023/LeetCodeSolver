package com.vic.solution.algorithm.sort

interface Sortable {
    fun <T> sort(array: Array<T>, comparator: Comparator<T>) {
        sort(array.toMutableList(), comparator)
    }

    fun <T> sort(list: MutableList<T>, comparator: Comparator<T>)
}