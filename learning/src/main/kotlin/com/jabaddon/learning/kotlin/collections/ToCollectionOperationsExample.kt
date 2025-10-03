package com.jabaddon.learning.kotlin.collections

fun main() {
    val targetList = ArrayList<Int>()
    val targetMap = HashMap<String, Int>()
    listOf(1, 2, 3, 4, 5)
        .printAndReturn()
        .filterTo(targetList) { n -> n % 2 == 0 }
        .printAndReturn()
        .associateByTo(targetMap) { "*" * it }
        .printAndReturn()
}

operator fun String.times(it: Int): String {
    return (1..it).joinToString(separator = "") { this }
}
