package com.jabaddon.learning.kotlin.basics.pkg

fun sayHiTo(m: String): String {
    return "Hello $m";
}

// top level functions are public by default
fun publicSubtract(a: Int, b: Int): Int {
    return a - b
}

// Cannot be call outside the file
private fun privateSum(a: Int, b: Int): Int {
    return a + b
}