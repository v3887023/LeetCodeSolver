package com.vic.solution

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

fun main() {
    val a = Int.MAX_VALUE / 2 + 10
    val b = Int.MAX_VALUE / 2 + 4

    val c = (a + b).ushr(1)
    val d = (a - b).shr(1) + b
    println(c)
    println(d)


    val list = listOf(1, 2, 3, 4)
    list.drop(2).forEach(::println)
    list.slice(1 until 3).take(1).forEach(::println)

    val n1 = 1000
    val n2 = Integer.valueOf(1000)

    println(n1 == n2)
    println(n1 === n2)
    println(Float.NaN)

    for (i in list.indices) {

    }

    val p = Person()
    //    p.name
    Person.name
    Person.abc()

    lock(ReentrantLock()) {
        doPrint()
    }

    println("start")

    list.forEach {
        if (it == 3) return@forEach
        println(it)
    }

    println("end")

    Student().name
    Student().isMan
}

fun a(list: List<Int>) {

}

class Person {
    companion object {
        const val name = 1

        init {
            println("init")
        }

        fun abc() {

        }
    }
}

enum class Color {
    RED, BLUE, PURPLE, ORANGE, YELLOW
}

inline fun <T> lock(l: Lock, block: () -> T) {
    l.lock()

    try {
        block()
    } finally {
        l.unlock()
    }
}

fun doPrint() {
    println("Hello world!")
}