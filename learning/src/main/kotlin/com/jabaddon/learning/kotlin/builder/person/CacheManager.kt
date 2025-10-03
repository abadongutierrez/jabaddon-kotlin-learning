package com.jabaddon.learning.kotlin.builder.person

import java.util.concurrent.ConcurrentHashMap

object CacheManager {
    private val cache = ConcurrentHashMap<String, Any>()

    fun put(key: String, value: Any) {
        cache[key] = value
    }

    fun <T> get(key: String): T? {
        @Suppress("UNCHECKED_CAST")
        return cache[key] as? T
    }

    fun remove(key: String) {
        cache.remove(key)
    }

    fun clear() {
        cache.clear()
    }

    fun containsKey(key: String): Boolean {
        return cache.containsKey(key)
    }
}
