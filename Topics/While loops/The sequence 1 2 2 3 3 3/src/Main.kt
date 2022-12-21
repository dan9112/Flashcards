fun main() {
    var iteration = 1
    var num = readln().toInt()
    while (num > 0) {
        repeat(if (iteration > num) num else iteration) { print("$iteration ") }
        num -= iteration
        iteration++
    }
}
