package com.jabaddon.learning.kotlin.classes

// https://kotlinlang.org/docs/sealed-classes.html#constructors
// A sealed class itself is always an abstract class, and as a result, can't be instantiated directly.
sealed class Error(val message: String)

class ErrorA(message: String) : Error(message)
class ErrorB(message: String) : Error(message)
open class ErrorC(message: String) : Error(message)

class ErrorX(message: String) : ErrorC(message)

fun printError(error: Error) {
    when (error) {
        is ErrorA -> println("Error A: ${error.message}")
        is ErrorB -> println("Error B: ${error.message}")
        is ErrorC -> println("Error C: ${error.message}")
    }
}

fun main() {
    val errorA = ErrorA("Error A message")
    val errorB = ErrorB("Error B message")
    val errorC = ErrorC("Error C message")

    printError(errorA)
    printError(errorB)
    printError(errorC)
    printError(ErrorX("Error X message"))
}