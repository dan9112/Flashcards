fun main() = println(
    try {
        readln().toInt() / readln().toInt()
    } catch (exception: ArithmeticException) {
        "Division by zero, please fix the second argument!"
    }
)