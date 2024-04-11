package com.jabaddon.learning.kotlin

internal class Person(val age: Int)
fun isEven(i: Int) = i % 2 == 0
fun main() {
    val list = listOf(1, 2, 3, 4)
    // function reference
    println(list.any(::isEven))

    val persons = listOf(Person(15), Person(20), Person(30))
    // method reference
    println(persons.maxBy(Person::age).age)
}