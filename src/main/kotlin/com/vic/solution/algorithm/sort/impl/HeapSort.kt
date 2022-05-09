package com.vic.solution.algorithm.sort.impl

import com.vic.solution.algorithm.sort.Sortable

/**
 * 堆排序
 */
class HeapSort : Sortable {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        val temp = array.copyOf()
        for (i in array.indices) {
            val it = array[i]
            val parentIndex = (i + 1) / 2
            val parent = array[parentIndex]
        }
    }
}