package com.jabaddon.learning.kotlin.lambdas

fun main() {
    { println("Hey") }()
    // or
    run { println("Hey") }

    val isEven: (Int) -> Boolean = { i -> i % 2 == 0 }
}