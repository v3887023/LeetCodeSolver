package com.vic.solution.algorithm.sort

interface Sortable {
    fun <T : Comparable<T>> sort(array: Array<T>)
}