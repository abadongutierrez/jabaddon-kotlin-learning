import java.lang.IllegalArgumentException

fun failWithWrongAge(age: Int?): Nothing {
    throw IllegalArgumentException("Wrong age: $age")
}

fun checkAge(age: Int?) {
    if (age == null || age !in 0..150) failWithWrongAge(age)
    // without the Nothing type, the next line would not compile because age could be null
    // and the compiler would not know what to do with the null value
    println("Congrats! Next year you'll be ${age + 1}.")
}

fun main() {
    checkAge(10)
}