import java.util.LinkedList

fun main() {
    val output = LinkedList<Char>()
    do {
        val input = readlnOrNull()
        input?.let {
            output.add(it.first() - 1)
        }
    } while (input != null)
    output.forEach { println(it) }
}
