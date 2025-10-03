package com.jabaddon.learning.kotlin.classes

fun main() {
    InitOrderDemo("Rafael") // using primary constructor
    println("----")
    InitOrderDemo()         // using secondary constructor
}

/*
 * https://kotlinlang.org/docs/classes.html#constructors
 * During the initialization of an instance, the initializer blocks are executed in
 * the same order as they appear in the class body, interleaved with the property initializers: 
 */
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)
    
    init {
        println("First initializer block that prints $name")
    }
    
    val secondProperty = "Second property: ${name.length}".also(::println)
    
    init {
        println("Second initializer block that prints ${name.length}")
    }

    constructor() : this("Rafael") {
        println("Secondary constructor")
    }
}