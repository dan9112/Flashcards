import kotlin.math.pow

fun main() {
    val totalSeconds = System.currentTimeMillis() / 1000
    println(secondsToTimeString(totalSeconds))
}

fun secondsToTimeString(seconds: Long): String {
    val dayTime = seconds % (24 * 3600)
    val timeStages = 3
    var result = ""
    repeat(timeStages) {
        var previousDivider = 60.0.pow(timeStages - it).toInt()
        if (it != 0) result += ':' else previousDivider = Int.MAX_VALUE
        result += dayTime % previousDivider / 60.0.pow(timeStages - 1 - it).toInt()
    }
    return result
}
