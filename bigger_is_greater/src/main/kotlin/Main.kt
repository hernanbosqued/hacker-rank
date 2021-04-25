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

            for (swapIndex in parameter.length - 1 downTo index) {
                if (parameter[swapIndex] > parameter[index]) {
                    builder.append(parameter[swapIndex])

                    val chars = parameter.toCharArray()
                    chars[swapIndex] = chars[index]
                    builder.append(chars.drop(index + 1).reversed().toCharArray())
                    break
                }
            }
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