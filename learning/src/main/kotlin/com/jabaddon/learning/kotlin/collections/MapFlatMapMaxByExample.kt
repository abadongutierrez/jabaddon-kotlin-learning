package com.jabaddon.learning.kotlin.collections

import com.jabaddon.learning.kotlin.collections.Gender.FEMALE
import com.jabaddon.learning.kotlin.collections.Gender.MALE

fun main() {
    val heroes = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE),
    )

    val (first, second) = heroes
        .flatMap { heroes.map { hero -> it to hero } }
        .maxBy { it.first.age - it.second.age }
    println(first.name)
    println(second.name)

    val (oldest, yonger) = heroes
        .flatMap { first -> heroes.map { second -> first to second } }
        .maxBy { it.first.age - it.second.age }
    println(oldest.name)
    println(yonger.name)
}
