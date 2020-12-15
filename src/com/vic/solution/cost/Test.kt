package com.zcx.pic

fun main() {
    runCost {
        val array = IntArray(100_0000) { i -> i }
        array.sum()
    }

    runCost {
        val array = Array<Int>(100_0000) { i -> i }
        array.sum()
    }
}

inline fun runCost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val cost = System.currentTimeMillis() - start

    println("cost ${cost}ms")
}