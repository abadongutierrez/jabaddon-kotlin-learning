package com.jabaddon.learning.kotlin.basics

fun main() {
    val instance = SomeClass("string value", 1)
    println("--")
    val instance2 = SomeClass()
}

class SomeClass(private val stringValue: String, var intValue: Int) {
    private lateinit var computedValue: String

    init {
        println("first init block")
        computedValue = "computed"
        println("$stringValue, $intValue, $computedValue")
    }

    init {
        println("second init block")
    }

    constructor() : this("", 1) {
        println("seconday constructor")
    }
}