package hernanbosqued.samples

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Hello world!")
        return
    }
    println("Hello, ${args[0]}!")
}