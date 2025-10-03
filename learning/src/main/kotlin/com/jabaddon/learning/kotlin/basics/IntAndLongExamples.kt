package com.jabaddon.learning.kotlin.basics
fun main() {
    val n1 : Int
    val n2 : Long

    n1 = 1024
    // n2 = n1 // Compilation error: Type mismatch: inferred type is Int but Long was expected
    n2 = n1.toLong()
    println(n2)
}