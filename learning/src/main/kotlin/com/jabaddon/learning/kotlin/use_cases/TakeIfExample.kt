package com.jabaddon.learning.kotlin.use_cases

fun main() {
    val condition = true && true

    // fancy if, DONT DO IT!
    (condition).takeIf { it }?.run {
        doSomething()
    }

    if (condition) {
        doSomething()
    }
}

fun doSomething() {
    println("Hey")
}
