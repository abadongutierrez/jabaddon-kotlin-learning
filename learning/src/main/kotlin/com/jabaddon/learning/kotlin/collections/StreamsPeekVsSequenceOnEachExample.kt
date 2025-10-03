package com.jabaddon.learning.kotlin.collections

fun main() {
    // Sequence onEach() is similar to Java Stream peek()
    listOf(1, 2, 3, 4, 5)
        .stream().peek { println(it) }
        .toList().asSequence()
        .onEach { println(it) }
        .toList()

}