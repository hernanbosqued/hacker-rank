package hernanbosqued.samples

import java.io.File
import java.util.*

fun biggerIsGreater(str: String): String {

    val list = str.toMutableList()

    var swapIndex = list.lastIndex
    var hasPermutation = false
    var response = ""

    for (index in list.lastIndex downTo 0) {
        if (list[index] < list[swapIndex]) {

            val pre = list.subList(0,index)
            val post = list.subList(index,list.size)

            val set = post.toSet().sorted()
            val charIndex = set.indexOf(list[index])

            pre.forEach { response += it }
            response += set[charIndex + 1]

           val postIndex = post.indexOf(set[charIndex + 1])
            post.removeAt(postIndex)
            post.sort()
            post.forEach { response += it }

            hasPermutation = true
            break
        } else {
            swapIndex = index
        }
    }
    return if (hasPermutation) {
        response
    } else {
        "no answer"
    }
}

fun main(args: Array<String>) {
    val file = File("./bigger_is_greater/src/resources/input.txt")
    val scanner = Scanner(file)
    val size = scanner.nextInt()

    for (item in 1..size) {
        val str = scanner.next()
        val result = biggerIsGreater(str)

        println(result)
    }
}