import kotlin.math.pow

fun main() = println(
    when (readln()) {
        "amount" -> finalAmount(startingAmount = inputDouble)
        "percent" -> finalAmount(yearlyPercent = inputDouble)
        "years" -> finalAmount(years = inputDouble)
        else -> "Unknown parameter"
    }
)

private fun finalAmount(startingAmount: Double = 1000.0, yearlyPercent: Double = 5.0, years: Double = 10.0) =
    (startingAmount * (1 + yearlyPercent / 100).pow(years)).toInt()

private val inputDouble
    get() = readln().toDouble()
