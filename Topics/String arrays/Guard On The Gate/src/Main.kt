fun main() {
    var backFromTheWall = readln().split(',').map { it }.toTypedArray()
    val returnedWatchman = readln()

    backFromTheWall += returnedWatchman
    println(backFromTheWall.joinToString(", "))

}