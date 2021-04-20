package hernanbosqued.samples

import java.text.SimpleDateFormat
import java.util.*

fun timeConversion(time: String): String {
    val fromFormatter = SimpleDateFormat("hh:mm:ssa")
    val date = fromFormatter.parse(time)

    val toFormatter = SimpleDateFormat("HH:mm:ss")
    return toFormatter.format(date)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = timeConversion(s)

    println(result)
}