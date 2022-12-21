fun main() {
    val backToTheWall = readln().split(", ").map { it }.toMutableList()
    // val returnedWatchman = readln()
    println(
        with(backToTheWall) {
            add(readln())
            joinToString()
        }
    )
}