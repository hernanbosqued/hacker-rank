package hernanbosqued.samples

import java.io.File
import java.util.*

inline fun CharSequence.compareReversed(predicate: (first: Char, second: Char) -> Boolean): Int {
    for (index in lastIndex - 1 downTo 0) {
        if (predicate(this[index], this[index + 1])) {
            return index
        }
    }
    return -1
}

fun biggerIsGreater(parameter: String): String {

    val builder = StringBuilder()

    return when (val index = parameter.compareReversed { first, second -> first < second }) {
        -1 -> "no answer"
        else -> {
            builder.append(parameter.substring(0, index))

            val post = parameter.substring(index, parameter.length).toMutableList()
            val symbols = post.toSet().sorted()
            val symbolIndex = symbols.indexOf(parameter[index])

            builder.append(symbols[symbolIndex + 1])

            val postIndex = post.indexOf(symbols[symbolIndex + 1])
            post.removeAt(postIndex)
            post.sort()
            builder.append(post.toCharArray())
            builder.toString()
        }
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