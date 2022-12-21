fun printIfPrime(number: Int) {
    var flag = true
    var i = 2
    while (flag && i < number) {
        if (number % i == 0) flag = false
        i++
    }
    println("$number is ${if (flag) "" else "not "}a prime number.")
}

fun main(args: Array<String>) {
    val number = readln().toInt()
    printIfPrime(number)
}
