fun intDivision(x: String, y: String) = try {
    x.toInt() / y.toInt()
} catch (e: Exception) {
    when (e) {
        is ArithmeticException -> println("Exception: division by zero!")
        is NumberFormatException -> println("Read values are not integers.")
    }
    0
}

fun main() {
    val x = readln()
    val y = readln()
    println(intDivision(x, y))

}