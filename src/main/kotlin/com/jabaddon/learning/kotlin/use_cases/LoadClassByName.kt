package com.jabaddon.learning.kotlin.use_cases

fun main() {
    try {
        Class.forName("intro.Main")
    } catch (_: Exception) {
        println("Error loading intro.Main, what about intro.MainKt?")
    }

    Class.forName("intro.MainKt")
    println("Yes!")
}
