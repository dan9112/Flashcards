fun main() {
    var distance = readln().toInt() // the distance back
    var totalDistance = readln().toInt()

    if (distance < 0) distance = -distance
    totalDistance += distance
    println(totalDistance)
}
