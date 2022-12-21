fun main() {
    var num = readln().toInt()
    while (num != 1) {
        print("$num ")
        num = if (num % 2 == 0) num / 2 else num * 3 + 1
    }
    print(num)
}
