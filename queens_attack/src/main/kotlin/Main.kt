package hernanbosqued.samples

import java.lang.IllegalArgumentException
import java.util.*

// Complete the queensAttack function below.
fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {

    val obstaclesSet = obstacles.map { Pair(it[0], it[1]) }.toSet()
    val queen = Pair(r_q, c_q)

    if (obstaclesSet.contains(queen) || n <= 0 || n > 1E5 || k < 0 || k > 1E5) {
        throw IllegalArgumentException()
    }

    val deltas = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1), Pair(-1, 1), Pair(1, 1), Pair(-1, -1), Pair(1, -1))

    return deltas.sumBy { findDistance(n, obstaclesSet, queen, it) }
}

fun findDistance(n: Int, obstacles: Set<Pair<Int, Int>>, queen: Pair<Int, Int>, delta: Pair<Int, Int>): Int {
    var distance = 0

    var point = Pair(queen.first + delta.first, queen.second + delta.second)

    while (point.first in 1..n && point.second in 1..n) {
        if (obstacles.contains(point)) {
            break
        } else distance++
        point = Pair(point.first + delta.first, point.second + delta.second)
    }
    return distance
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val r_qC_q = scan.nextLine().split(" ")

    val r_q = r_qC_q[0].trim().toInt()

    val c_q = r_qC_q[1].trim().toInt()

    val obstacles = Array<Array<Int>>(k, { Array<Int>(2, { 0 }) })

    for (i in 0 until k) {
        obstacles[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = queensAttack(n, k, r_q, c_q, obstacles)

    println(result)
}