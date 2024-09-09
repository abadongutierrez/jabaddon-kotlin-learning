package com.jabaddon.learning.kotlin.builder.person

data class PersonDto(val name: String, val lastName: Int)

// This delcares a class with a constructor that receives some parameters but there is no properties declared
// val/var creates properties if used
class PersonNoProps(name: String, lastName: String)

class Person(val name: String, val lastName: String) {
    // this is a mutable property
    var fullName = "$name $lastName"
}

class ClassWithMultipleInitBlocs(name: String, lastName: String) {
    private val name: String = "$name"
    init {
        println("init 1: $name")
    }

    private val lastName: String = "$lastName"
    init {
        println("init 2: $lastName")
    }
}

class Pet(name: String) {

    init {
        println("Pet init")
    }

    constructor(name: String, owner: Person) : this(name) {
        println("Pet secondary constructor")
    }
}

class DontCreateMe private constructor () {
    // This is a private constructor so it is not possible to create an instance of this class
}