package com.jabaddon.learning.kotlin.basics

fun main() {
    println(listOf(1, 2, 3).joinToString(separator = ":"))
    println(listOf(1, 2, 3).joinToString(postfix = ")", prefix = "("))
}