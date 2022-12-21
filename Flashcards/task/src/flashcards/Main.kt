package flashcards

import java.io.File
import kotlin.io.path.writeLines

private val cards: Cards = Cards.CardsMap()
private val logList = mutableListOf<String>()

private val commands = listOf(
    ::add, ::remove, ::import, ::export, ::ask, ::exit, ::log, ::`hardest card`, ::`reset stats`
).associateBy { it.name }

fun main(args: Array<String>) {
    with(checkArgs(args)) {
        main()
        this?.let {
            println()
            export(it)
        }
    }
}

private val checkArgs = { arguments: Array<String> ->
    var exportFileName: String? = null
    var i = 0
    while (i < arguments.lastIndex) {
        when (arguments[i]) {
            "-import" -> {
                import(arguments[++i])
                println()
            }
            "-export" ->
                exportFileName = arguments[++i]
        }
        i++
    }
    exportFileName
}

private val main = {
    do {
        val name = readlnAfterPrintln("Input the action ${commands.keys.joinToString()}:")
        commands[name]?.invoke() ?: println("Invalid command!")
        println()
    } while (name != "exit")
}

private data class DuplicateException(val isTerm: Boolean, val value: String) : Exception()

private fun add() = with(cards) {
    fun getString(isTerm: Boolean) = readln().let {
        if (isTerm && containsTerm(it) || !isTerm && containsDefinition(it))
            throw DuplicateException(isTerm, it)
        it
    }
    try {
        with(
            printlnWithAction("The card:") { getString(true) } to
                    printlnWithAction("The definition of the card:") { getString(false) }
        ) {
            add(first, second)
            println("The pair (\"$first\":\"$second\") has been added.")
        }
    } catch (e: DuplicateException) {
        with(e) {
            println("The ${if (isTerm) "card" else "definition"} \"$value\" already exists.")
        }
    }
}

private fun ask() = with(cards) {
    if (isEmpty()) println("Nothing to ask")
    else {
        println("How many times to ask?")
        try {
            val count = readln().toInt()
            repeat(count) {
                val card = getRandomCard()
                println("Print the definition of \"${card.first}\"")
                val definition = readln()
                println(
                    if (definition == card.second) "Correct!"
                    else {
                        wrongAnswer(card.first)
                        val term = getTerm(definition)
                        if (term == null) "Wrong. The right answer is \"${card.second}\"."
                        else "Wrong. The right answer is \"${card.second}\", but your definition is correct for \"$term\"."
                    }
                )
            }
        } catch (e: NumberFormatException) {
            println("Invalid data format")
        }
    }
}

private fun exit() = println("Bye bye!")

private fun export() = export(readlnAfterPrintln("File name:"))

private fun export(fileName: String) {
    if (cards.isEmpty()) File(fileName).writeText("")
    else with(StringBuilder()) {
        cards.forEach { append("${it.first}\t${it.second}\t${it.third}\n") }
        File(fileName).writeText(substring(0, lastIndexOf('\n')))
    }

    with(cards) {
        println(
            "${
                when {
                    count() > 1 -> "${count()} cards have"
                    count() == 1 -> "1 card has"
                    else -> "Nothing has"
                }
            } been saved."
        )
    }
}

private fun `hardest card`() = with(cards.getHardestTerm()) {
    println(
        when {
            isEmpty() -> "There are no cards with errors."
            count() == 1 -> keys.first().let {
                "The hardest card is \"$it\". You have ${this[it]} errors answering it."
            }
            else -> "The hardest cards are \"${
                keys.joinToString("\", \"")
            }\". You have ${values.first()} errors answering them."
        }
    )
}

private fun import() = import(readlnAfterPrintln("File name:"))

private fun import(fileName: String) {
    val file = File(fileName)
    if (!file.exists()) println("File not found.")
    else try {
        with(file.readLines()) {
            forEach {
                val data = it.split('\t')
                cards.add(data[0], data[1], data[2].toInt())
            }
            if (cards.isNotEmpty()) println(
                "\"${
                    when {
                        count() > 1 -> "${count()} cards have"
                        count() == 1 -> "1 card has"
                        else -> "Nothing has"
                    }
                } been loaded.\""
            )
        }
    } catch (e: Exception) {
        println("Invalid data in file!")
    }
}

private fun log() {
    val fileName = readlnAfterPrintln("File name:")
    File(fileName).toPath().writeLines(logList)
    println("The log has been saved.")
}

private fun remove() {
    println("Which card?")
    readln().also {
        println(if (cards.remove(it)) "The card has been removed." else "Can't remove \"$it\": there is no such card.")
    }
}

private fun <T, R> printlnWithAction(consoleOutput: R, action: () -> T) = println(consoleOutput).run { action() }

private fun readlnAfterPrintln(text: String) = printlnWithAction(text) { readln() }

private fun println() {
    logList.add("")
    kotlin.io.println()
}

private fun println(message: Any?) = with(message.toString()) {
    logList.add(this)
    kotlin.io.println(this)
}

private fun readln() = kotlin.io.readln().also { logList.add(it) }

private fun `reset stats`() = printlnWithAction("Card statistics have been reset.") { cards.resetErrors() }
