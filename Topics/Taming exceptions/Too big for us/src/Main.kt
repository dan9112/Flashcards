fun returnValue() = readln().toInt().let {
    if (it <= 0) {
        it
    } else {
        throw Exception("It's too big")
    }
}
