open class Tea(val cost: Int, val volume: Int) {
    override fun toString() = "cost=$cost, volume=$volume"
}

class BlackTea(cost: Int, volume: Int) : Tea(cost, volume) {
    override fun toString() = "BlackTea{${super.toString()}}"
}
