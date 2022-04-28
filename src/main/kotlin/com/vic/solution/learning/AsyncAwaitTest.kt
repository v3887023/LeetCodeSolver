package com.vic.solution.learning

import kotlin.coroutines.*

fun getUserName(): Call<String> {
    return Call("Victor")
}

interface AsyncScope

class Call<T>(var data: T)

fun main() {
    async {
        val userName = await { getUserName() }
        println(userName)
    }
}

fun async(context: CoroutineContext = EmptyCoroutineContext, block: suspend AsyncScope.() -> Unit) {
    val completion = AsyncCoroutine(context)
    block.startCoroutine(completion, completion)
}

class AsyncCoroutine(override val context: CoroutineContext = EmptyCoroutineContext) : Continuation<Unit>, AsyncScope {
    override fun resumeWith(result: Result<Unit>) {}
}

suspend fun <T> AsyncScope.await(block: () -> Call<T>): T {
    return suspendCoroutine {
        val call = block()

        Thread.sleep(1000)
        it.resume(call.data)
    }
}