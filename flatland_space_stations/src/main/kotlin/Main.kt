package hernanbosqued.samples

import java.lang.Integer.max
import java.util.Scanner

// Complete the flatlandSpaceStations function below.
fun flatlandSpaceStations(n: Int, c: Array<Int>): Int {
    if (n < 1 || n > 1e5 || c.isEmpty() || c.size > n) {
        throw IllegalArgumentException()
    }

    c.sort()
    var result = c[0]

    for (index in 0 until c.size - 1) {
        val distance = (c[index + 1] - c[index]) / 2
        if (result < distance) {
            result = distance
        }
    }
    result = max(result, n - 1 - c.last())
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")

    val n = nm[0].trim().toInt()

    val m = nm[1].trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = flatlandSpaceStations(n, c)

    println(result)
}
