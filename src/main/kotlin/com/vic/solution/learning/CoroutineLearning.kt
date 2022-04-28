package com.vic.solution.learning

import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.RestrictsSuspension
import kotlin.coroutines.startCoroutine

suspend fun main() {
    suspend {
        suspendFunc1("first call suspend func 1", 2)
        suspendFunc1("second call suspend func 1", 3)
    }.startCoroutine(object : Continuation<Int> {
        override val context = LogInterceptor()

        override fun resumeWith(result: Result<Int>) {
            println(result.getOrNull())
        }

    })

    sequence {
        yield(1)
    }.forEach {
        println(it)
    }


}

class LogInterceptor : ContinuationInterceptor {
    override val key = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>) = LogContinuation(continuation)
}

class LogContinuation<T>(private val continuation: Continuation<T>) : Continuation<T> by continuation {
    override fun resumeWith(result: Result<T>) {
        println("before resumeWith")
        continuation.resumeWith(result)
        println("after resumeWith")
    }
}

suspend fun suspendFunc1(message: String, result: Int): Int {
    println(message)
    return result
}