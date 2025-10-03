package com.jabaddon.learning.kotlin.exercises

import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Test

class Game2024Test {
    @Test
    fun test() {
        listOf("a", "a", "b").dragToRight { it.repeat(2) } shouldBeEqual listOf("aa", "b")
        listOf("a", "a", null, "b").dragToRight { it?.repeat(2) } shouldBeEqual listOf("aa", "b")
        listOf("a", null, "a", "b").dragToRight { it?.repeat(2) } shouldBeEqual listOf("aa", "b")
        listOf("a", null, "a", "b", "b").dragToRight { it?.repeat(2) } shouldBeEqual listOf("aa", "bb")
        listOf("a", null, "a", "b", "b", "c").dragToRight { it?.repeat(2) } shouldBeEqual listOf("aa", "bb", "c")
    }

    @Test
    fun test2() {
        listOf(1, 1, 1, 5).dragToRight { it * 2 } shouldBeEqual listOf(2, 1, 5)
    }
}