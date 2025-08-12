package com.jabaddon.learning.kotlin.result_pattern

import com.github.michaelbull.result.*

fun apiRequestSuccess(): Result<String, String> {
    return Ok("Success")
}

fun apiRequestFailure(): Result<String, String> {
    return Err("Error")
}


fun process(message: String, shouldFail: Boolean = false): Result<String, String> {
    return if (shouldFail) Err("Processing failed in $message") else Ok("Processing succeeded in $message")
}

fun main() {
    apiRequestSuccess()
        .map { response: String ->
            println("Response: $response")
        }.mapError { error: String ->
            println("Error: $error")
        }

    apiRequestFailure()
        .map { response: String ->
            println("Response: $response")
        }.mapError { error: String ->
            println("Error: $error")
        }

    apiRequestFailure()
        .andThen {
            apiRequestFailure()
        }.mapError { error: String ->
            println("Error in andThen: $error")
        }.map { response: String ->
            println("Response in andThen: $response")
        }

    process("1")
        .andThen {
            process("2")
        }.andThen {
            process("3", shouldFail = false)
                .andThen {
                    process("4", shouldFail = true)
                }
        }
        .mapError { error: String ->
            println("Final Error: $error")
        }
}