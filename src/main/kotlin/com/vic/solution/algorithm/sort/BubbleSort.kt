package com.vic.solution.algorithm.sort

class BubbleSort : Sortable {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        var sorted: Boolean
        val size = array.size

        for (j in size - 1 downTo 0) {

            sorted = true
            for (i in 0 until j) {
                if (array[i] > array[i + 1]) {
                    array.swap(i, i + 1)
                    sorted = false
                }
            }

            if (sorted) break
        }
    }
}