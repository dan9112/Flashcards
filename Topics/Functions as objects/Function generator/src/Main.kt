// TODO: provide three functions here

fun generate(functionName: String): (Int) -> Int = { it ->
    when (functionName) {
        "identity" -> it
        "half" -> it / 2
        else -> 0
    }
}
