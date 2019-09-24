fun box() {
    val three: Any = TODO()

    open class Local(val one: Int) {
        fun value() = "$three$one"
    }

    data class Derived(val two: Int) : Local(1)
}