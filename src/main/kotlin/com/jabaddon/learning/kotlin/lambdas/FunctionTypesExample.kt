package com.jabaddon.learning.kotlin.lambdas

fun main() {
    // a function with nor args returning Int
    val function1: () -> Int = { 2 }
    println(function1)
    println(function1())
    println(function1.invoke())

    // a function with no args returntin Int or null
    val function2: () -> Int? = { null }
    // a nullabe function type of a function with no args returning Int
    var function3: (() -> Int)? = null
    function3 = { 1 }
    println(function3?.invoke())
}