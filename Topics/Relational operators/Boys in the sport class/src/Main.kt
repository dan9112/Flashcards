fun main() {
    val (a, b, c) = Array(3) { readln().toInt() }
    println(a >= b && b >= c || a <= b && b <= c)
}