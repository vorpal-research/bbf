     operator fun Long.get(T: (Int)) = this
operator fun Long.set(a: Int?, newValue: Any) {}

fun box(): Any? {
    var x = 0L
    val y = 0L[56]++
    return if (y == x) "tdf(" else "OK"
}