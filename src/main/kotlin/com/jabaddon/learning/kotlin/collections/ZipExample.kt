package com.jabaddon.learning.kotlin.collections

fun main() {
    val vehicles = listOf("Veh1", "Veh2", "Veh3", "Veh4", "Veh5", "Veh6")
    val drivers = listOf("Drv1", "Drv2", "Drv3", "Drv4")

    val pairs = vehicles.zip(drivers)

    // Print the pairs
    pairs.forEach { (vehicle, driver) ->
        println("Vehicle: $vehicle, Driver: $driver")
    }
}