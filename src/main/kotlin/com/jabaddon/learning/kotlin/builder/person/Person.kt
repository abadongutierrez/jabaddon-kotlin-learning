package com.jabaddon.learning.kotlin.builder.person

data class PersonDto(val name: String, val lastName: Int)

class Person(val name: String, val lastName: String) {
    var fullName = "$name $lastName"
}