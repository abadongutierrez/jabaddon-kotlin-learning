package com.jabaddon.learning.kotlin.classes

fun main() {
    val wholeName = WholeName("Miguel", "Bautista")
    println(wholeName.getOtherName())
    wholeName.setNewName("Miguel Valentino")
    println(wholeName.getOtherName())
}

data class WholeNameV1(val name: String, val lastName: String) {}
class WholeName(name: String, lastName: String) {

    // Custom getter and setter for 'name'
    private var name: String = name
    get() {
        println("Getting name: $field")
        return field
    }
    set(value) {
        if (value.isNotBlank()) {
            println("Setting name to: $value")
            field = value
        } else {
            println("Invalid name")
        }
    }

    // Custom getter and setter for 'lastName'
    private var lastName: String = lastName
    get() {
        println("Getting lastName: $field")
        return field
    }
    set(value) {
        if (value.isNotBlank()) {
            println("Setting lastName to: $value")
            field = value
        } else {
            println("Invalid lastName")
        }
    }

    fun getOtherName(): String {
        return name
    }

    fun setNewName(newName: String) {
        println("Before setting new name")
        name = newName
    }
}