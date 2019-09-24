class Host(var value: String
) {
    operator fun get(i: Int, j: Int?, k: Int) = value

    operator fun set(i: Int, j: Int, k: Int, newValue: String): Unit = TODO()
}

fun box() {
    val x = Host("")
    run {
        x[0, 0, 0] += "K"
    }
}
