import kotlin.math.cos
import kotlin.math.sin

fun main() = readDouble().let { println(sin(it) - cos(it)) }

private val readDouble = { readln().toDouble() }
