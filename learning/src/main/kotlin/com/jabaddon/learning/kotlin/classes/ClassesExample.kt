package com.jabaddon.learning.kotlin.builder

import com.jabaddon.learning.kotlin.builder.person.Person
import com.jabaddon.learning.kotlin.builder.person.PersonNoProps
import com.jabaddon.learning.kotlin.builder.person.ClassWithMultipleInitBlocs
import com.jabaddon.learning.kotlin.builder.person.Pet

fun main() {
    val person = Person("John", "Doe")
    println(person.fullName)
    person.fullName = "Jane Doe set"
    println(person.fullName)
    //val person2 = PersonBuilder().name("John").age(30).build()
    //println(person2)

    val p1 = PersonNoProps("John", "Doe")
    // no p1.name

    val c1 = ClassWithMultipleInitBlocs("John", "Doe")

    val pet1 = Pet("Spike", person)
}