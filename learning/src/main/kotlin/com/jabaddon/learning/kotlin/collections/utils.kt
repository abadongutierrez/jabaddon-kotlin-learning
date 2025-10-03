package com.jabaddon.learning.kotlin.collections

fun <E> Collection<E>.printAndReturn(): Collection<E> {
    println(this)
    return this
}

fun <K, V> Map<K, V>.printAndReturn(): Map<K, V> {
    println(this)
    return this
}