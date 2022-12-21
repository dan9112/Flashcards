fun printFifthCharacter(input: String) = try {
    "The fifth character of the entered word is ${input[4]}"
} catch (exception: StringIndexOutOfBoundsException) {
    "The input word is too short!"
}