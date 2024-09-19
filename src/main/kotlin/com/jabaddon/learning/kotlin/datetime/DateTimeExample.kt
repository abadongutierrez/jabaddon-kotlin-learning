package com.jabaddon.learning.kotlin.datetime

import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.ZoneId
import java.time.OffsetDateTime
import java.time.ZoneOffset

fun main() {
    // takes the time from the system clock
    val localNow = LocalDateTime.now()
    println("local now " + localNow)
    val chicagoTimeZone = ZoneId.of("America/Chicago")
    val nowInChicago = ZonedDateTime.now(chicagoTimeZone)
    println("date/time at chicago " + nowInChicago)
    
    // how to move a local date time to zoned date time?
    // First you need to set the zone to the local date time and move to the desired zone
    val zdtMexicoCity = ZonedDateTime.of(localNow, ZoneId.of("America/Mexico_City"))
    println("ZonedDateTime.of(localNow, ZoneId.of(\"America/Mexico_City\")) = " + zdtMexicoCity)
    println("ZonedDateTime.of(localNow, ZoneId.of(\"America/Mexico_City\")).withZoneSameInstant(chicagoTimeZone) = " +
        zdtMexicoCity.withZoneSameInstant(chicagoTimeZone))
}