package com.jabaddon.learning.kotlin.basics

fun List<Int>.allNonZero() = this.all { it > 0 }
fun List<Int>.allNonZero1() = this.none { it == 0 }
fun List<Int>.allNonZero2() = this.any { it > 0 }

fun List<Int>.containsZero() = this.any { it == 0 }
fun List<Int>.containsZero1() = this.all { it == 0 }
fun List<Int>.containsZero2() = this.none { it == 0 }

fun main(args: Array<String>) {
    val list1 = listOf(1, 2, 3)
    list1.allNonZero() eq true
    list1.allNonZero1() eq true
    list1.allNonZero2() eq true

    list1.containsZero() eq false
    list1.containsZero1() eq false
    list1.containsZero2() eq false

    val list2 = listOf(0, 1, 2)
    list2.allNonZero() eq false
    list2.allNonZero1() eq false
    list2.allNonZero2() eq false

    list2.containsZero() eq true
    list2.containsZero1() eq true
}

private infix fun Boolean.eq(b: Boolean) {
    println(if (this == b) "OK" else "NOK")
}
