fun main() {
    val (x, y, z) = List(3) { readln().toBoolean() }
    println(!(x&&y) || z)
}
