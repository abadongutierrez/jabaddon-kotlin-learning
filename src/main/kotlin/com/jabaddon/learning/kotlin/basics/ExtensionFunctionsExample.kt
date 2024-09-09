package com.jabaddon.learning.kotlin.basics

fun main() {
    println("hola".lastChar())
    println(listOf(1, 2, 3).sum())

    // Not able to resolve sum since this is a List<String> 
    //listOf("1", "2", "3").sum()
}

fun String.lastChar() = this.get(this.length-1)

fun List<Int>.sum(): Int {
    var result = 0;
    for (i in this) result += i
    return result
}