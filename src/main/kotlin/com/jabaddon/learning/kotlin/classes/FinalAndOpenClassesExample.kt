package com.jabaddon.learning.kotlin.classes

// for Animal in order to be "extendable" needs to be open since all classes are final by default
open class Animal {
    // same happens with methods (non-abstract methods)
    // methods need to be open, so they can be overwritten
    open fun makeSound(): String {
        return "brrrr"
    }
}

class Lion: Animal() {

    override fun makeSound(): String {
        return "miau"
    }
}
fun main() {
    // classes are final by default
    val list = listOf(Animal(), Lion())
    list.forEach { println(it.makeSound()) }
}