package com.jabaddon.learning.kotlin.lambdas

fun main() {
    localReturn(listOf("1", "2", "3", "4", "5", "6"))
    localReturnWithLabel(listOf("1", "2", "3", "4", "5", "6"))
}

fun localReturn(list: List<String>) {
    var counter = 1
    list.forEach {
        println(it)
        if (counter == 3) {
            println("counter == 3")
            return@forEach
        }
        counter++
    }
    println("End of loop")
}

fun localReturnWithLabel(list: List<String>) {
    var counter = 1
    list.forEach myLabel@{
        println(it)
        if (counter == 3) {
            println("counter == 3")
            return@myLabel
        }
        counter++
    }
    println("End of loop")
}