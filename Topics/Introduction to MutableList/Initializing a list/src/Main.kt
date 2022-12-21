fun main() {
    val numbers = MutableList(100) {
        Math.log10((it + 1).toDouble()).run {
            if (this - toInt() != 0.0) 0 else it + 1
        }
    }
    println(numbers.joinToString())
}
