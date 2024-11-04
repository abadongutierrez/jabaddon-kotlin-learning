package com.jabaddon.learning.kotlin.exercises

fun main() {
}

fun <E> List<E>.dragToRight(mergeFun: (E) -> E): List<E> {
    val output = mutableListOf<E>()
    this.filterNot { it == null }.forEach {
        if (output.isEmpty() || output.last() != it) {
            output.add(it)
        } else {
            output[output.lastIndex] = mergeFun(output.last())
        }
    }
    return output.toList()
}
