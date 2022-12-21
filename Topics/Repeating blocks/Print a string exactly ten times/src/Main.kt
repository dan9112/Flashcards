const val REPEAT_COUNT = 10

fun main() = with(readln()) {
    repeat(REPEAT_COUNT) {
        println(this)
    }
}