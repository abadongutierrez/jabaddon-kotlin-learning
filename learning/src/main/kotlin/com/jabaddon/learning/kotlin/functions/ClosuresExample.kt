package com.jabaddon.learning.kotlin.functions

import java.math.BigDecimal

var percentage = 0.02;

fun computePercentage(salary: BigDecimal): BigDecimal {
    return salary * (BigDecimal.ONE + percentage.toBigDecimal())
}

fun main() {
    println(computePercentage(1000.00.toBigDecimal()))
    percentage = 0.05
    println(computePercentage(1000.00.toBigDecimal()))
}