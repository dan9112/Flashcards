const val NUMBER_COUNT = 3

fun main() {
    var one: Boolean? = null
    repeat(NUMBER_COUNT) {
        if (readln().toInt() > 0) one = one == null
    }
    println(one ?: false)
}
