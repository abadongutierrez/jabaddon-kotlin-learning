package com.jabaddon.learning.kotlin.dates

import java.time.Duration
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.math.absoluteValue

fun main() {
    val message = DateRange(LocalDate.now(), LocalDate.now().plusDays(50))
    println(message.daysBetween())
    val (r1, r2) = message.splitAt(LocalDate.now().plusDays(24))
    println(r1.daysBetween())
    println(r2.daysBetween())
}

data class DateRange(val start: LocalDate, val end: LocalDate) {
    fun daysBetween(): Long {
        return ChronoUnit.DAYS.between(start, end).absoluteValue
    }

    fun splitAt(date: LocalDate): Pair<DateRange, DateRange> {
        if (date in start..end) {
            return DateRange(start, date) to DateRange(date, end)
        }
        throw IllegalArgumentException()
    }
}