package com.jabaddon.learning.kotlin.basics

import kotlin.math.max

fun main() {
    val r = displayMax(10, 11)
    println(r)
}

// return Unit
private fun displayMax(a: Int, b: Int) {
    println(max(a, b))
}


private fun displayMaxReturningUnit(a: Int, b: Int): Unit {
    println(max(a,b))
}