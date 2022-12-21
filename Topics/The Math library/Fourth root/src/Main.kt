import kotlin.math.pow

private const val ROOT = 1.0 / 4

fun main() = println(readDouble().pow(ROOT))

private val readDouble = { readln().toDouble() }
