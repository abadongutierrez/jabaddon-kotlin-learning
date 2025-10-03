package com.jabaddon.learning.kotlin.basics

fun main() {
    val list = listOf("apple", "banana", "cherry")

    for (item in list) {
        println("Item $item")
    }

    for (index in list.indices) {
        println("Item at index $index is ${list[index]}")
    }

    for ((index, value) in list.withIndex()) {
        println("Item at index $index is $value")
    }

    list.forEach { item ->
        println(item)
    }

    list.forEachIndexed { index, value ->
        println("Item at index $index is $value")
    }
}