package hernanbosqued.samples

import java.lang.RuntimeException
import java.util.*

// Complete the queensAttack function below.
fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {

    val allObstacles = mutableSetOf<Pair<Int, Int>>()
    allObstacles.addAll(obstacles.map { Pair(it[0], it[1]) })

    if (allObstacles.contains(Pair(r_q, c_q))) {
        throw RuntimeException("obstacle in queen cell")
    }

    if( n <= 0 || n > 1E5){
        throw RuntimeException("max number of rows and columns are 1x10E5")
    }

    if( k < 0 || k > 1E5){
        throw RuntimeException("max number of obstacles are 1x10E5")
    }

    for (i in 0..n + 1) {
        allObstacles.add(Pair(0, i))
        allObstacles.add(Pair(n + 1, i))
        allObstacles.add(Pair(i, 0))
        allObstacles.add(Pair(i, n + 1))
    }

    val queen = Pair(r_q, c_q)

    val left = findDistance(allObstacles, queen, Pair(-1, 0))
    val right = findDistance(allObstacles, queen, Pair(1, 0))
    val bottom = findDistance(allObstacles, queen, Pair(0, -1))
    val top = findDistance(allObstacles, queen, Pair(0, 1))
    val leftTop = findDistance(allObstacles, queen, Pair(-1, 1))
    val rightTop = findDistance(allObstacles, queen, Pair(1, 1))
    val leftBottom = findDistance(allObstacles, queen, Pair(-1, -1))
    val rightBottom = findDistance(allObstacles, queen, Pair(1, -1))

    return top + bottom + left + right + leftTop + rightTop + leftBottom + rightBottom
}

fun findDistance(wallObstacles: Set<Pair<Int, Int>>, queen: Pair<Int, Int>, delta: Pair<Int, Int>): Int {
    var distance = 0

    var point = queen

    while (true) {
        point = Pair(point.first + delta.first, point.second + delta.second)
        if (wallObstacles.contains(point)) {
            return distance
        } else distance++
    }
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