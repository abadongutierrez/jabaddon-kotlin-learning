import java.util.*
import kotlin.math.abs
import kotlin.collections.mutableListOf

/*
Question:
Algorithms: Resume Sort

Raymond has found a trick to impress the interviewers.
He rated his projects on a scale from 0 to 100. He decides to include the projects in his resume such that the ratings of all the projects done before any project should be less than or equal to that project.

Assist Raymond in deciding the maximum number of projects that he can add to his resume.

Function Description
In the provided code snippet, implement the provided resumeTrick(...) method to print the maximum number of projects that Raymond can add to his resume. You can write your code in the space below the phrase “WRITE YOUR LOGIC HERE”.

There will be multiple test cases running so the Input and Output should match exactly as provided.
The base Output variable result is set to a default value of -404 which can be modified. Additionally, you can add or remove these output variables.

Input Format
The first line contains an integer N, denoting the number of projects.
The second line contains N space-separated floating-point numbers, representing ratings of the ith project.

Sample Input

5    -- denotes N

 
Constraints
0 < A[i] <= 100
0 < N < 700

Output Format
The output contains the maximum number of projects that Raymond can include in his resume​​​​​​.

Sample Output
3
 
Explanation
Raymond can add the 1st, 3rd, and 5th projects to his resume.
{2.0, 5.0, 16.0} will be the set of non-decreasing set of ratings of the projects.
Hence, the output is 3.
 */

fun longestIncreasingSubsequence(ratings: List<Double>): Int {
    val list = mutableListOf<Double>()
    for (rating in ratings) {
        val pos = Collections.binarySearch(list, rating)
        //println("rating = $rating, pos = $pos, lis = $lis")
        if (pos < 0) {
            val insertPos = abs(pos) - 1
            if (insertPos == list.size) {
                list.add(rating)
            } else {
                list[insertPos] = rating
            }
        }
    }
    return list.size
}

fun resumeTrick(ratings: FloatArray): Int {
    //this is default OUTPUT. You can change it.
    var result = 1
    // write your logic here:
    val list = mutableListOf<Float>()
    ratings.forEach { rating ->
        if (list.isEmpty()) {
            list.add(rating)
        } else {
            val index = list.indexOfFirst { item -> item >= rating }
            if (index == -1) {
                list.add(rating)
            } else {
                list[index] = rating
            }
        }
     }

    return list.size
}

fun main() {
    val list = listOf(
        listOf(2.0, 20.0, 5.0, 1.0, 16.0) to 3,
        listOf(24.68, 41.25, 90.05, 1.59, 13.47, 97.83, 29.79, 1.38, 21.36, 36.03) to 4,
        listOf(18.37, 19.00, 30.41, 38.85, 90.14, 96.36, 19.61, 61.06, 8.30, 72.16, 21.06, 83.63, 99.39, 79.49, 4.38, 31.51, 1.83, 64.65, 53.77, 43.60) to 8,
        listOf(54.46, 35.04, 30.38, 49.88, 19.24, 74.00, 90.61, 18.00, 71.48, 59.80, 35.87, 90.91, 54.20, 26.19, 28.66, 12.27, 93.47, 48.58, 89.85, 93.05, 81.07, 5.04, 92.35, 61.03, 52.98, 77.41, 59.17, 81.49, 36.73, 35.38, 69.53, 45.44, 46.28, 14.38, 58.08, 60.08, 55.47, 39.50, 3.62, 95.98, 85.93, 66.83, 4.99, 23.26, 49.52, 95.81, 21.11, 20.78, 72.58, 14.18, 75.14, 59.36, 98.84, 60.53, 67.35, 5.85, 56.06, 77.71, 33.20, 25.56, 33.31, 79.02, 42.44, 90.27, 17.07, 15.04, 90.41, 26.15, 16.54, 31.49, 87.73, 19.58, 27.77, 11.50, 52.17, 63.59, 16.62, 75.80, 49.10, 19.45, 61.45, 5.47, 69.78, 60.78, 62.03, 45.28, 44.23, 23.64, 25.56, 26.35, 44.24, 11.97, 64.29, 25.24, 66.86, 26.56, 77.25, 50.32, 39.35, 79.06) to 15,
    )
    list.forEach { (ratings, expected) ->
        println("For list $ratings")
        println("${longestIncreasingSubsequence(ratings)}, expected = $expected") // Output: 3
        println("${resumeTrick(ratings.map { it.toFloat() }.toFloatArray())}, expected = $expected") // Output: 3
    }
}
/*
2.0 - [2.0]
20.0 - [2.0, 20.0]
5.0 - [2.0, 5.0] (replace 20.0 with 5.0)
1.0 - [2.0, 5.0]
1

*/