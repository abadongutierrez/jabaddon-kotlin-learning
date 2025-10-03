package com.jabaddon.learning.kotlin.starprojection

// sealed and data class are incompatible in Kotlin
// sealed and abstract is redundant in Kotlin
sealed class Request<T>(
    val params: T)

data class StringRequest(val message: String) : Request<String>(params = message)

data class IntRequest(val number: Int) : Request<Int>(params = number)

data class Data(
    val id: String,
    val name: String
)

data class DataRequest(val data: Data) : Request<Data>(params = data)

fun main() {
    val stringRequest = StringRequest("Hello")
    val intRequest = IntRequest(42)
    val dataRequest = DataRequest(Data("1", "Sample"))

    println(stringRequest.params) // Output: Hello
    println(intRequest.params) // Output: 42
    println(dataRequest.params) // Output: Data(id=1, name=Sample)
}

fun printRequest(request: Request<*>) {
    when (request) {
        is StringRequest -> println("String Request: ${request.params}")
        is IntRequest -> println("Int Request: ${request.params}")
        is DataRequest -> println("Data Request: ${request.params}")
    }
}