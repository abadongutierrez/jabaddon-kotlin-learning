package com.jabaddon.learning.kotlin.lambdas

fun main() {
    foo()
}

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) {
            run {
                run {
                    return
                }
            }
        } // non-local return directly to the caller of foo()
        print(it)
    }
    println("this point is unreachable")
}