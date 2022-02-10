package com.vic.solution.algorithm.sort

fun main() {
    val list = mutableListOf(8, 12, 9, 1, 90, 3, 0, 100, -2, 9)
    val comparator = Comparator<Int> { o1, o2 -> o1 - o2 }

    BubbleSort().sort(list, comparator)
}