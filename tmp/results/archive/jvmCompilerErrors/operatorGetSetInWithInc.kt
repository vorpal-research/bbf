object Map1 {
    operator fun get(i: Int) = 1
    operator fun set(i: Int?, newValue: Int) {}
}

fun box() {
    Map1[0]++
}