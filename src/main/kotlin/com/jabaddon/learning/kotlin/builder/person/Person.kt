package com.jabaddon.learning.kotlin.builder.person

data class PersonDto(val name: String, val lastName: Int)

class PersonNoProps(name: String, lastName: String)

class Person(name: String, lastName: String) {
    var fullName = "$name $lastName"
}