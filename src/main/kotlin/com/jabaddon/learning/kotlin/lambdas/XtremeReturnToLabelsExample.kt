package com.jabaddon.learning.kotlin.lambdas

fun main() {
    run hi2@{
        println("Hola 2")

        run hi@{
            println("Hola")
            run {
                return@hi2
            }
            println("Hello again!")
        }
    }
}
