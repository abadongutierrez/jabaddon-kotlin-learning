package com.jabaddon.learning.kotlin.interview

// A closure is the combination of a function bundled together (enclosed) with references to its surrounding state (the lexical environment).
// In other words, a closure gives you access to an outer function's scope from an inner function.
fun main() {
    var counter = 0
    val funn = { println("The value of counter is $counter") }
    funn()
    counter++
    funn()
}