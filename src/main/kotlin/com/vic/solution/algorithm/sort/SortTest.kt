package com.vic.solution.algorithm.sort

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

    array = originArray.copyOf()
    QuickSort().sort(array)
    array.println()
    array.checkSorted()
}