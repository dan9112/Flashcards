import kotlin.random.Random

fun sumInts() = randomInt0to100 + randomInt0to100

private val randomInt0to100
    get() = Random.nextInt(101)