package com.jabaddon.learning.kotlin.collections

/*
Kotlin's collection are not lazy they ar eager, we get fully populated collections from each call
 */
fun main() {
    listOf(1, 2, 3, 4, 5).printAndReturn()
        .filter { n -> n % 2 == 1 }.printAndReturn()
        .map { n -> n * n }.printAndReturn()
        .drop(1).printAndReturn()
        .take(1).printAndReturn()
}