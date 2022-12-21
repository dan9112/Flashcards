import kotlin.math.sqrt

private const val TRIANGLE_SIDES = 3

fun main() = println(
    List(TRIANGLE_SIDES) { readDouble() }.let {
        val p = it.sum() / 2
        sqrt(p * (p - it[0]) * (p - it[1]) * (p - it[2]))
    }
)

private val readDouble = { readln().toDouble() }
