import Buffer.StandardReadWithSave
import Buffer.value

fun main() {
    println("$StandardReadWithSave plus $StandardReadWithSave equals $value")
    // clear
}

private object Buffer {
    var value = 0
    val StandardReadWithSave
        get() = readln().toInt().also { value += it }
    /*
    val clear: Unit
        get() {
            value = 0
        }
     */
}
