inline class Z(val Any: Int) {
    fun g(x: () -> Boolean = { super.equals(TODO()) }) = x
}