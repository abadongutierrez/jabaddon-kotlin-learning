package com.jabaddon.learning.kotlin.patterns.creational

fun main() {
    val s1 = SingletonHardWay.getInstance()
    val s2 = SingletonHardWay.getInstance()

    // === compares references in Kotlin
    println(s1 === s2) // Should print true, both references point to the same instance

    val globalCounter = GlobalCounter
    val gc1 = GlobalCounter
    globalCounter.increment()
    println("Global counter: ${globalCounter.count}")
    gc1.increment()
    println("Global counter after increment: ${globalCounter.count}")

    processEvent(Event.Created)
    processEvent(Event.Updated)
    processEvent(Event.Deleted)
}

class OtherSingleton private constructor() {
    companion object {
        private val INSTANCE: OtherSingleton by lazy { OtherSingleton() }

        @JvmStatic
        // JvmStatic annotation allows the companion object method to be called as a static method in Java
        fun getInstance() = INSTANCE
    }
}

// SingletonHardWay demonstrates a thread-safe singleton implementation using double-checked locking
// This pattern ensures that the singleton instance is created only when it is needed,
// and it is safe to use in a multi-threaded environment.
class SingletonHardWay private constructor() {

    // Private constructor prevents instantiation from outside the class
    // The instance is created lazily and is thread-safe
    companion object {
        // lateinit - Used to declare a non-nullable variable that will be initialized later
        private lateinit var instance: SingletonHardWay

        fun getInstance(): SingletonHardWay {
            // ::instance.isInitialized - Checks if the instance has been initialized
            if (!::instance.isInitialized) {
                synchronized(this) {
                    if (!::instance.isInitialized) { // Double-checked locking
                        instance = SingletonHardWay()
                    }
                }
            }
            return instance
        }
    }
}

object GlobalCounter {
    // @Volatile ensures visibility of changes across threads - prevents CPU caching issues
    @Volatile
    var count = 0
        private set

    init {
        count = 0
    }

    // @Synchronized ensures thread-safe access - only one thread can execute this method at a time
    // Prevents race conditions when multiple threads increment the counter simultaneously
    @Synchronized
    fun increment() {
        count++
    }
}

sealed class Event {
    data object Created : Event()
    data object Updated : Event()
    data object Deleted : Event()
}

fun processEvent(event: Event) {
    when (event) {
        is Event.Created -> println("Processing Created event")
        is Event.Updated -> println("Processing Updated event")
        is Event.Deleted -> println("Processing Deleted event")
    }
}

