package com.vic.solution.algorithm.sort.impl

import com.vic.solution.algorithm.sort.Sortable
import com.vic.solution.algorithm.swap

/**
 * 堆排序
 */
class HeapSort : Sortable {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        // 构建大顶堆
        buildMaxHeap(array)

        var size = array.size
        for (i in array.lastIndex downTo 0) {
            // 随着第 0 个节点和第 i 个节点的交换，数组末尾的元素一直是有序的
            // 所以 size 的值在逐渐减小
            array.swap(0, i)
            heapify(array, 0, --size)
        }
    }

    private fun <T : Comparable<T>> buildMaxHeap(array: Array<T>) {
        val size = array.size
        // 最后一个非叶子结点的索引
        val lastNonLeafNodeIndex = size / 2 - 1
        for (i in lastNonLeafNodeIndex downTo 0) {
            heapify(array, i, size)
        }
    }

    /**
     * 使以第 i 个结点为顶的二叉树成为一个堆
     */
    private fun <T : Comparable<T>> heapify(array: Array<T>, i: Int, size: Int) {
        val leftChildIndex = 2 * i + 1
        val rightChildIndex = 2 * i + 2
        var maxIndex = i

        if (leftChildIndex < size && array[leftChildIndex] > array[maxIndex]) {
            maxIndex = leftChildIndex
        }

        if (rightChildIndex < size && array[rightChildIndex] > array[maxIndex]) {
            maxIndex = rightChildIndex
        }

        if (maxIndex != i) {
            // 需要交换结点
            array.swap(i, maxIndex)
            // 由于父子结点交换了位置，需要确保以交换后的结点为顶的二叉树也是一个堆，需要递归
            heapify(array, maxIndex, size)
        }
    }
}