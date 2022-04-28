package com.vic.solution.learning

fun main() {
    test({ 2 }) {
        val a = 2
        val b = 3
        return@test a + b
    }
}

private inline fun test(block: () -> Int, crossinline result: () -> Int) {
    println(result())
}