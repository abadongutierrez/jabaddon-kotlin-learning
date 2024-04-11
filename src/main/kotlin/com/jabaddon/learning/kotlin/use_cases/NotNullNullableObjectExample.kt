package com.jabaddon.learning.kotlin.use_cases

fun main() {
    println("hola")
    val driver = createUninsuredDriver()

    driver.currentInsurance()?.let { (insurance, carrierName) ->
        println(carrierName)
    }

    val driver2 = createInsuredDriver()

    driver2.currentInsurance()?.let { (insurance, carrierName) ->
        println(carrierName)
    }
}

fun createInsuredDriver(): Driver {
    val driver = Driver(Insurance(true, "AAA"))
    return driver
}

fun createUninsuredDriver(): Driver {
    val driver = Driver(Insurance(false, null))
    return driver
}

class Driver(val insurance: Insurance) {
    fun currentInsurance(): Pair<Insurance, String>? {
        if (insurance.insured && insurance.carrierName != null) {
            return Pair(insurance, insurance.carrierName)
        }
        return null
    }
}

class Insurance(val insured: Boolean, val carrierName: String?)
