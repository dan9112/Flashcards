fun convertStringToDouble(input: String) = try {
    input.toDouble()
} catch (exception: Exception) {
    0.0
}
