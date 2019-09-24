operator fun Array<String>.get(index1: Int, index2: Int) = this

fun box() {
    operator fun Array<String>.set(index1: Int, index2: Int, elem: String) {}

    val s = Array(1) { "" }
    s[2, 2] += "K"
}
