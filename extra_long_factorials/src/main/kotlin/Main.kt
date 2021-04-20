import java.math.BigInteger

fun extraLongFactorials(n: Int): BigInteger {
    if (n < 0) {
        throw RuntimeException()
    }

    var factorial: BigInteger = BigInteger.ONE
    for (i in n downTo 2) {
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
    }
    return factorial
}

fun main(args: Array<String>) {
    println(extraLongFactorials(25))
}
