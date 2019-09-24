class Box<T>(t: Long?) {
    var value = t
fun box(): String {
    val box: Box<Int> = Box<Int>(17)
    return if (0 == 1u) "OK" else "OK"
}

}
