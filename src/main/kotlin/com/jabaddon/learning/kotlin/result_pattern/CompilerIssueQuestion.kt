package com.jabaddon.learning.kotlin.result_pattern

import com.github.michaelbull.result.*
import java.lang.Exception

class Service {
    fun doSomething(fail: Boolean): Result<ServiceResult, Exception> {
        return if (fail) Err(Exception("Error")) else Ok(ServiceResult(data = listOf(1,2,3)))
    }
}

data class ServiceResult(val id: Int = 1, val message: String = "done", val data: List<Int>)

fun run(): Result<List<Int>, String> {
    return Service().doSomething(true)
        .map { serviceResult: ServiceResult ->
            serviceResult.data.map { value ->
                value * 2
            }
        }
        .mapError { e -> e.message!! }
}

fun run2(): Result<List<Int>, String> {
    fun inner(serviceResult: ServiceResult): List<Int> {
        val map = serviceResult.data.map { value ->
            value * 2
        }
        return map
    }

    return Service().doSomething(true)
        .map { inner(it) }
        .mapError { e -> e.message!! }
}