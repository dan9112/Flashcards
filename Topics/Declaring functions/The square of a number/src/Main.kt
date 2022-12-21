private val square = { number: Int -> number * number }

fun main() {
    val number = readln().toInt()
    println(square(number))
}
