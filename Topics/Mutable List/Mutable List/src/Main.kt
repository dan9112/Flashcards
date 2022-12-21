fun names(namesList: List<String>) = namesList.groupingBy { it }.eachCount().map { (key, value) ->
    "The name $key is repeated $value times"
}
