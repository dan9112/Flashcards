private fun isGreater(a: Int, b: Int, c: Int, d: Int) = a + b > c + d

fun main() {
    val number1 = readln().toInt()
    val number2 = readln().toInt()
    val number3 = readln().toInt()
    val number4 = readln().toInt()

    println(isGreater(number1, number2, number3, number4))
}