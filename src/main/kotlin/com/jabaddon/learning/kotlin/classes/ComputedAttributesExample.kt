package com.jabaddon.learning.kotlin.classes

class Employee(var salary: Double) {
    val tax: Double = salary * 0.3
        get() {
            println("Current tax: $field")
            return salary * 0.3
        }
}

class Employee2(private var _salary: Double) {
    var salary: Double
        get() = _salary
        set(value) {
            _salary = value
            tax = calculateTax() // Recalculate tax when salary is modified
        }

    var tax: Double = calculateTax()
        private set // Prevent external modification of tax

    private fun calculateTax(): Double {
        return _salary * 0.30
    }
}
fun main() {
    val e = Employee(10000.0)
    println(e.tax)
    e.salary = 5000.0
    println(e.tax)

    // I dont like this
    val e2 = Employee2(_salary = 10000.0)

}