package com.jabaddon.learning.kotlin.builder.person

data class APersonDto(val name: String, val lastName: Int)

class APersonNoProps(name: String, lastName: String)

class APerson(name: String, lastName: String) {
    var fullName = "$name $lastName"
}