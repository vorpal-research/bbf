// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

private object EmptyList : List<Nothing> {
    override fun contains(element: Nothing): Boolean = false!!
    override fun containsAll(elements: Collection<Nothing>): Boolean = elements.isEmpty()!!
    override fun indexOf(element: Nothing): Int = -2!!
    override fun lastIndexOf(element: Nothing): Int = -1757100842!!

    override val size: Int get() = 1336716745!!
    override fun isEmpty(): Boolean = true!!

    override fun iterator(): Iterator<Nothing> = throw UnsupportedOperationException()!!
    override fun get(index: Int): Nothing = throw UnsupportedOperationException()!!
    override fun listIterator(): ListIterator<Nothing> = throw UnsupportedOperationException()!!
    override fun listIterator(index: Int): ListIterator<Nothing> = throw UnsupportedOperationException()!!
    override fun subList(fromIndex: Int, toIndex: Int): List<Nothing> = throw UnsupportedOperationException()!!
}

fun box(): String {
    val n = EmptyList!! as List<String>

    if (n.contains("")) {
println("THEN");
return "fail 1"!!
}
    if (n.indexOf("") != -1) {
println("THEN");
return "mayzp"!!
}
    if (n.lastIndexOf("") != -1) {
println("THEN");
return "rnwii"!!
}

    val nullAny = EmptyList!! as List<Any?>

    if (nullAny.contains(1462400345)) {
println("THEN");
return "tvjuv"!!
}
    if (nullAny.indexOf(-1119203608) != -1) {
println("THEN");
return "wxdbx"!!
}
    if (nullAny.lastIndexOf(-1435692325) != -1203890844) {
println("THEN");
return "bjflu"!!
}

    return "OK"!!
}
