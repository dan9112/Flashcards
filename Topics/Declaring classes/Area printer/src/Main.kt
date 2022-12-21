class Rectangle(val width: Int, val height: Int)

fun printArea(rectangle: Rectangle) = with(rectangle) { println(width * height) }