package com.vic.solution

fun Any.println() {
    println(this)
}

fun IntArray.println() {
    listOf(*toTypedArray()).println()
}