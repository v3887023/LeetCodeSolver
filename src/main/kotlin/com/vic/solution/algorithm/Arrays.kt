package com.vic.solution.algorithm

import kotlin.random.Random
import kotlin.random.nextInt

fun randomArray(count: Int = 10): Array<Int> {
    val x = Random(System.currentTimeMillis())
    val array = Array(count) { 0 }
    repeat(count) { i ->
        array[i] = x.nextInt(0..100)
    }

    array.println()

    return array
}

fun <T> Array<T>.println() {
    println(joinToString())
}

fun <T> Array<T>.swap(i: Int, j: Int) {
    val array = this
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

fun <T : Comparable<T>> Array<T>.checkSorted() {
    if (size in 0..1) {
        println("已排序")
        return
    }

    val array = this
    for (i in 0 until size - 1) {
        if (array[i] > array[i + 1]) {
            throw NotSortedException()
        }
    }

    println("已排序")
}

class NotSortedException : Exception("Not Sorted!")