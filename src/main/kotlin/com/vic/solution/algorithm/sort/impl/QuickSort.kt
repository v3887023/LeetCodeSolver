package com.vic.solution.algorithm.sort.impl

import com.vic.solution.algorithm.println
import com.vic.solution.algorithm.sort.Sortable
import com.vic.solution.algorithm.swap

/**
 * 快速排序
 */
class QuickSort : Sortable {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        quickSort(array, 0, array.lastIndex)
    }

    private fun getPivotIndex(start: Int, end: Int) = (start + end) / 2

    private fun <T : Comparable<T>> quickSort(array: Array<T>, start: Int, end: Int) {
        val count = end - start + 1
        if (count < 2) return

        val pivotIndex = getPivotIndex(start, end)
        val pivot = array[pivotIndex]

        var i = start
        var j = end
        while (i <= j) {
            // 从左边开始找比 pivot 大的数
            while (i <= end && array[i] <= pivot) {
                i++
            }

            // 从右边开始找比 pivot 小的数
            while (j >= start && array[j] >= pivot) {
                j--
            }

            if (i < j) {
                array.swap(i, j)
                i++
                j--
            }
        }


        if (j < start) {
            array.swap(start, pivotIndex)
            array.println()
            quickSort(array, start + 1, end)
        } else if (i < end) {
            val newPivotIndex = i
            array.swap(newPivotIndex, pivotIndex)
            array.println()
            quickSort(array, start, newPivotIndex - 1)
            quickSort(array, newPivotIndex + 1, end)
        } else {
            array.swap(end, pivotIndex)
            array.println()
            quickSort(array, start, end - 1)
        }
    }
}