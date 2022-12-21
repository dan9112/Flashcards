fun main() = readDouble().let {
    println(readDouble() - it)
}

private val readDouble = { readln().toDouble() }