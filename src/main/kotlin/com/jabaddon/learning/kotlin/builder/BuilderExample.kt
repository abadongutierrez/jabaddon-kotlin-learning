package com.jabaddon.learning.kotlin.builder

import com.jabaddon.learning.kotlin.builder.person.Person

fun main() {
    val person = Person("John", "Doe")
    println(person.fullName)
    person.fullName = "Jane Doe set"
    println(person.fullName)
    //val person2 = PersonBuilder().name("John").age(30).build()
    //println(person2)
}