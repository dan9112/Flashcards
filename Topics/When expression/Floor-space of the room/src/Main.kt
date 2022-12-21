import kotlin.math.pow
import kotlin.math.sqrt

fun main() = println(
    when (readln()) {
        "rectangle" -> readDouble() * readDouble()
        "circle" -> 3.14 * readDouble().pow(2)
        "triangle" -> Array(3) { readDouble() }.let {
            val p = (it[0] + it[1] + it[2]) / 2
            sqrt(p * (p - it[0]) * (p - it[1]) * (p - it[2]))
        }
        else -> "Unknown figure"
    }
)

private val readDouble = { readln().toDouble() }