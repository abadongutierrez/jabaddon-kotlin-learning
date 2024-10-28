package com.jabaddon.learning.kotlin.basics

fun main() {
    // creates and initializes the array of 10 elements to 0's
    val array = IntArray(10)
    println(array.joinToString(", "))

    array[3] = 100
    println(array.joinToString(", "))

    val map = array.groupBy {
        when (it) {
            0 -> "ZERO"
            else -> "OTHER"
        }
    }
    println(map)

    val biDimensionalArray = arrayOf(
        IntArray(3),
        IntArray(3),
        IntArray(3),
    )
    biDimensionalArray.indices.forEach { row ->
        biDimensionalArray[row].indices.forEach { col ->
            print(biDimensionalArray[row][col])
        }
        println()
    }

    val array1 =
        arrayOf(
            arrayOf(
                IntArray(3)
            )
        )
    println(array1[0][0][0])

    val array2 = IntArray(10, { r -> r * 2 })
    println(array2.joinToString(", "))
    var array3 = array2.copyOf()
    array2[0] = 1000
    println(array2.joinToString(", "))
    println(array3.joinToString(", "))


    val fromVararg = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(fromVararg.joinToString(", "))
}
