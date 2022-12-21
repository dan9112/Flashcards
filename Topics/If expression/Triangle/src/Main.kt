fun main() {
    val (a, b, c) = Array(3) { readln().toInt() }
    println(if (a + b > c && a + c > b && b + c > a) "YES" else "NO")
}