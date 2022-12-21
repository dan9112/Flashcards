import kotlin.math.pow

private const val INPUT_COUNT = 4
private const val rangeStartLimit = 0
private const val rangeEndLimit = 1000

fun main() {
    val (a, b, c, d) = List(INPUT_COUNT) { readln().toInt() }
    for (x in rangeStartLimit..rangeEndLimit) {
        if (a * x.toDouble().pow(3.0) + b * x.toDouble().pow(2.0) + c * x + d == 0.0) println(x)
    }
}
