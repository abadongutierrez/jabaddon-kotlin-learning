const val question = "life, the universe, and everything"
const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer"""

fun main() {
    println("---")
    println(tripleQuotedString)
    println("---")
    println(tripleQuotedString.trimIndent())
    println("---")
    println(tripleQuotedString.trimMargin("#"))
    println("---")
}