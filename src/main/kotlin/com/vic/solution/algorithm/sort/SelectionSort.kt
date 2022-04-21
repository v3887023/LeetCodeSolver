package com.vic.solution.algorithm.sort

class SelectionSort : Sortable {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        val size = array.size
        for (i in 0 until size - 1) {
            var minIndex = i
            for (j in i + 1 until size) {
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }
            array.swap(i, minIndex)
        }
    }
}