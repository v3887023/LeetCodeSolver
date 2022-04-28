package com.vic.solution.algorithm

import com.vic.solution.algorithm.sort.impl.HeapSort

fun main() {
    val originArray = randomArray()
    var array: Array<Int>

//    array = originArray.copyOf()
//    BubbleSort().sort(array)
//    array.println()
//    array.checkSorted()
//
//    array = originArray.copyOf()
//    SelectionSort().sort(array)
//    array.println()
//    array.checkSorted()
//
//    array = originArray.copyOf()
//    InsertionSort().sort(array)
//    array.println()
//    array.checkSorted()

//    array = originArray.copyOf()
//    array = arrayOf(56, 68, 18, 34, 4, 98, 93)
//    array.println()
//    QuickSort().sort(array)
//    array.println()
//    array.checkSorted()

//    array = originArray.copyOf()
//    array = arrayOf(1,3,5,2,4,6,8)
//    MergeSort().sort(array)
//    array.println()
//    array.checkSorted()

//    array = originArray.copyOf()
    array = arrayOf(3, 1, 7, 2, 6, 0, 5)
    HeapSort().sort(array)
    array.println()
    array.checkSorted()
}