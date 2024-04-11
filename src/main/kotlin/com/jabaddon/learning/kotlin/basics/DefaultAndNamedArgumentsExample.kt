package com.jabaddon.learning.kotlin.basics

fun main() {
    displayTimes('#', 5)
    displayTimes()
    // using named arguments to change the order
    displayTimes(i = 2, c = '-')
}

fun displayTimes(c: Char = '*', i: Int = 10) {
    repeat(i) {
        print(c)
    }
}
