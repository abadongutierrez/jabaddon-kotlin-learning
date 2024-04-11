package com.jabaddon.learning.kotlin.basics


fun main() {
    var nullValue: String? = null
    // elvis operator
    // if not null use the value, if null use the value after "?:"
    println(nullValue ?: "elvis: value when is null")

    // if-else expression
    println(if (nullValue == null) "if-else: is null" else "if-else: not null")

    // let, if not null, run the code block
    nullValue = "Hola"
    nullValue?.let {
        println("let: If not null")
    }

    // let-run, if null, run the run block
    nullValue = null
    nullValue?.let {
        println("let-run: If not null")
    }.run {
        println("let-run: when null value")
    }
}