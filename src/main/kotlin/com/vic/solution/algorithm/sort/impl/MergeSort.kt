package com.vic.solution.algorithm.sort.impl

import com.vic.solution.algorithm.sort.Sortable

class MergeSort : Sortable {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        val temp = array.copyOf()
        mergeSort(array, 0, array.lastIndex, temp)
    }

    private fun <T : Comparable<T>> mergeSort(array: Array<T>, left: Int, right: Int, temp: Array<T>) {
        if (left == right) {
            return
        }

        val mid = (left + right) / 2
        mergeSort(array, left, mid, temp)
        mergeSort(array, mid + 1, right, temp)
        merge(array, left, mid + 1, right, temp)
    }

    private fun <T : Comparable<T>> merge(array: Array<T>, left: Int, rightBegin: Int, right: Int, temp: Array<T>) {
        var i = left
        var j = rightBegin
        var index = left
        while (i < rightBegin && j <= right) {
            if (array[i] < array[j]) {
                temp[index] = array[i++]
            } else {
                temp[index] = array[j++]
            }
            index++
        }

        while (i < rightBegin) {
            temp[index++] = array[i++]
        }

        while (j <= right) {
            temp[index++] = array[j++]
        }

        for (k in left..right) {
            array[k] = temp[k]
        }
    }
}