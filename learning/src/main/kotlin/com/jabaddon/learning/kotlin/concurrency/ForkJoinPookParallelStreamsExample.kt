package com.jabaddon.learning.kotlin.concurrency

import java.math.BigInteger
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ForkJoinTask

class MyTask(private val limit: Int): ForkJoinTask<BigInteger>() {
    private var rawResult: BigInteger? = null
    override fun getRawResult(): BigInteger {
        return rawResult ?: (-1).toBigInteger();
    }

    override fun exec(): Boolean {
        val numbers = (1..limit).toList()
        val sum = numbers.parallelStream()
            .map { it.toBigInteger() * it.toBigInteger() }
            .reduce(0.toBigInteger()) { a, b -> a + b }

        println("Sum of squares: $sum")
        rawResult = sum
        return true
    }

    override fun setRawResult(value: BigInteger?) {
        TODO("Not yet implemented")
    }

}
fun main() {
    // Get the number of available processors
    val availableProcessors = Runtime.getRuntime().availableProcessors()

    // Create a custom ForkJoinPool with a specific number of threads

    val customPool = ForkJoinPool(availableProcessors)

    // Use the custom pool to invoke parallel operations
    val startTime = System.nanoTime()
    val future = customPool.invoke(MyTask(10_000_000))
    val endTime = System.nanoTime()
    val duration = endTime - startTime

    println("Done $future")
    println("Execution time: ${duration / 1_000_000} ms")
}