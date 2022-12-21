fun main() = List(readInt()) { readInt() }
    .run { if (contains(readInt())) "YES" else "NO" }
    .run(::println)

private val readInt = { readln().toInt() }
