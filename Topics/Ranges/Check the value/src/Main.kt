import java.io.File

// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    println(File("/home/lord/Загрузки/words_with_numbers.txt").readLines().count { it.toIntOrNull() != null })
}
