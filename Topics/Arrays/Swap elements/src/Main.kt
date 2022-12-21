fun main() {
    val numbers = readln().split(' ').map { it.toInt() }.toIntArray()
    numbers[numbers.lastIndex] = numbers.first().also {
        numbers[0] = numbers.last()
    }
    println(numbers.joinToString(separator = " "))
}