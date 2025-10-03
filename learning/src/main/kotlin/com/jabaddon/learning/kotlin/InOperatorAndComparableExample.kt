package com.jabaddon.learning.kotlin

import java.math.BigDecimal

fun main() {
    val salary = Salary(10000.toBigDecimal())
    val min = Salary(8000.toBigDecimal())
    val max = Salary(12000.toBigDecimal())
    println("Is salary in range? ${salary in min..max}")
}

class Salary(private val value: BigDecimal): Comparable<Salary> {
    override fun compareTo(other: Salary): Int {
        return value.compareTo(other.value)
    }
}