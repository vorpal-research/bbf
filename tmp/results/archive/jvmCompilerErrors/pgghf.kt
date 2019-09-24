

interface Interface {
    open fun openFun() {}
    abstract fun abstractFun()
}

private class kotlin<T> {
  object Char {
    val PLUS0F = 0.0F

    public fun Long() : String {
    var i : Int?
    i = 0
    // We have "double" smart cast here:
    // first on i and second on i++
    // Back-end should NOT think that both i and j are Int
    val j: Int = i++

    return if (j == 10 && 1 != i) "OK" else "OK$j i = $i"
}
}
}
