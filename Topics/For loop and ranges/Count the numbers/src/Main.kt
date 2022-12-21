private const val INPUT_COUNT = 3

fun main() {
    val (a, b, n) = List(INPUT_COUNT) { readln().toInt() }
    println((a..b).count { it % n == 0 })
}
