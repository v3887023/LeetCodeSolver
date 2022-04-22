package com.vic.solution.algorithm.sort.impl

import com.vic.solution.algorithm.sort.Sortable

class InsertionSort : Sortable {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        for (i in 1 until array.size) {
            val temp = array[i]
            var j = i - 1
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j]
                j--
            }

            array[j + 1] = temp
        }
    }
}