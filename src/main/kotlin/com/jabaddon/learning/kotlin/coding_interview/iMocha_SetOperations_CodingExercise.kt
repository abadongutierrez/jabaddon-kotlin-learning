

import kotlin.math.abs

fun setOperation(A: Int, B: Int): Int {
    //this is default OUTPUT. You can change it.
    var result = -404

    // write your Logic here:
    val theSet = mutableListOf<Int>(A, B)
    var index1 = 0
    var index2 = 1
    while (index1 != theSet.size - 1) {
        val nextVal = abs(theSet[index1] - theSet[index2])
        // here we can improve by finding the nextVal in theSet in O(1) time, like using a HashSet
        if (theSet.contains(nextVal)) {
            index1++
        } else {
            theSet.add(nextVal)
            index2 = theSet.size - 1
        }
    }
    
    return theSet.min()
}

fun main() {
    listOf(
        Pair(15, 25) to 5,
        Pair(78, 54) to 6,
        Pair(1287, 2079) to 99,
    ).forEach({
        val (input, expected) = it
        val result = setOperation(input.first, input.second)
        println("input = $input, result = $result, expected = $expected")
    })

}