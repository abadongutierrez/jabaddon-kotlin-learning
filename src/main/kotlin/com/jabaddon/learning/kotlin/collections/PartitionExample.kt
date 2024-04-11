package com.jabaddon.learning.kotlin.collections

fun main() {
    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.MALE),
    )

    val (upToThirty, older) = heroes.partition { it.age <= 30 }
    println(upToThirty)
    println(older)
}