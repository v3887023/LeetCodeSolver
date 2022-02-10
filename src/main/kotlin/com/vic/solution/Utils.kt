package com.vic.solution

fun Any.println() {
    println(this)
}

fun IntArray.println() {
    listOf(*toTypedArray()).println()
}

inline fun runCost(tag: String = "", block: () -> Unit) {
    val startMillis = System.currentTimeMillis()

    block()

    val cost = System.currentTimeMillis() - startMillis

    buildString {
        if (tag.isNotEmpty()) {
            append(tag).append(' ')
        }

        append("cost ${cost}ms")
    }.println()
}