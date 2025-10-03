package com.jabaddon.learning.kotlin.basics

import java.util.*

data class Industry(val name: String, val sector: String) {
    fun mapToModel(): String {
        println("Mapping to model")
        return name
    }
}

fun main() {
    val v: Optional<String> = Optional.of("Hola")
    val v2 = Optional.empty<Industry>()
    println(v.get())
    println(v2.orElse(null))
    println(v2.map { it.mapToModel() }.orElse(null))
}