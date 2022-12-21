data class Fabric(var color: String) {
    var pattern = "none"
    var patternColor = "none"

    init {
        println("$color fabric is created")
    }

    constructor(color: String, pattern: String, patternColor: String) : this(color) {
        this.pattern = pattern
        this.patternColor = patternColor

        println("$patternColor $pattern pattern is printed on the fabric")
    }
}
