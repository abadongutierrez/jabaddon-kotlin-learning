package com.jabaddon.learning.kotlin.starprojection

sealed class Response<T>(
    val param: T
)

class StringResponse(message: String) : Response<String>(param = message)

class IntResponse(number: Int) : Response<Int>(param = number)

class DataResponse(data: Data) : Response<Data>(param = data)

fun reply(data: Any): Response<*> {
    return when (data) {
        is String -> StringResponse(data)
        is Int -> IntResponse(data)
        is Data -> DataResponse(data)
        else -> throw IllegalArgumentException("Unsupported data type")
    }
}

fun main() {
    val stringResponse = reply("Hello")
    val intResponse = reply(42)
    val dataResponse = reply(Data("1", "Sample"))

    println(stringResponse.param) // Output: Hello
    println(intResponse.param) // Output: 42
    println(dataResponse.param) // Output: Data(id=1, name=Sample)
}