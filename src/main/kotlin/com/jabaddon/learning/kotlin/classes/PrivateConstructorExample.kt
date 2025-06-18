package com.jabaddon.learning.kotlin.classes

fun main() {
    val p = Person.create("Rafael")
    println(p.name)
}

class Person private constructor(val name: String) {
    companion object {
        fun create(name: String) = Person(name)
    }
}