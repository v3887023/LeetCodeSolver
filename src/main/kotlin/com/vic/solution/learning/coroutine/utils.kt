package com.vic.solution.learning.coroutine

import java.util.concurrent.TimeUnit
import kotlin.coroutines.suspendCoroutine

suspend fun delay(time: Long, unit: TimeUnit = TimeUnit.MILLISECONDS) {
    if (time <= 0) {
        return
    }

    suspendCoroutine<Unit> { continuation ->

    }
}