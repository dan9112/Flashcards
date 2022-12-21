fun main() {
    val (a, b, c) = Array(3) { readln().toInt() }
    println((a + b) % 20 == 0 || (a + c) % 20 == 0 || (b + c) % 20 == 0)
}