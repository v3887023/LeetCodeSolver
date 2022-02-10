package com.vic.solution

import java.util.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

fun main() {
    val s = Data("ABC", 1)
    println(s.javaClass)
    println(s::class.java)
    println(s::javaClass)
    println(s::class)

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

class Factory {
    companion object : Runnable {
        @JvmField
        var field: Int = 90

        @JvmStatic
        override fun run() {

            Int.let {
                this::class.java
                this.javaClass
                this::javaClass
                val kClass = this::class
                kClass
            }
        }
    }
}

fun main2() {

    // 函数引用
    val kFunction11 = ::isOdd
    val a: (Int) -> Boolean = ::isOdd

    val kFunction1 = LinkedList<Int>::isNotEmpty

    // 属性引用
    val kProperty1 = String::lastIndex
    val c: (String) -> Int = String::lastIndex

    // 构造函数引用
    val kFunction2 = ::Data


    val list = listOf("1", "2", "3")
    list.map(String::length).forEach(::println)
    list.map { it.length }.forEach { println(it) }

    list.maxByOrNull { it.length }

    list.forEach { println(it) }
    for (n in list) {
        println(n)
    }
}

fun isOdd(n: Int): Boolean {
    return false
}

fun foo1(body: () -> Unit) {
    body()
}

fun bar1() {
    print("bar1")
}

class Data(val message: String, val code: Int)