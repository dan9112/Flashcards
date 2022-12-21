fun main() {
    val (a, op, b) = Array(3) { readln() }
    println(
        when (op) {
            "equals" -> a == b
            "plus" -> a + b
            "endsWith" -> a.endsWith(b)
            else -> "Unknown operation"
        }
    )
}
