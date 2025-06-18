package com.jabaddon.learning.kotlin.patterns.creational

fun main() {
    val s1 = SingletonHardWay.getInstance()
    val s2 = SingletonHardWay.getInstance()

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


class SingletonHardWay private constructor() {
    companion object {
        private lateinit var instance: SingletonHardWay

        fun getInstance(): SingletonHardWay {
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
    var count = 0
        private set

    init {
        count = 0
    }

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

