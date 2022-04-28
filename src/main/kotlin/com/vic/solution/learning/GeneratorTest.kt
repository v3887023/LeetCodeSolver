package com.vic.solution.learning

interface Generator<T> {
    operator fun iterator(): Iterator<T>
}

