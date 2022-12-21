data class Box(val height: Int, val length: Int, val width: Int)

fun main() = Array(4) { readln().toInt() }.let {
    with(Box(it[0], it[1], it[3])) {
        println("$this\n${copy(length = it[2])}")
    }
}
