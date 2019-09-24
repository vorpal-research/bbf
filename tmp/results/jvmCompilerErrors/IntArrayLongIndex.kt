operator fun IntArray.set(index: Long, elem: Int) {}

operator fun IntArray.get(index: Long) = this

fun box() {
    val l = IntArray(1)
    l[0.toLong()] += 6
}
