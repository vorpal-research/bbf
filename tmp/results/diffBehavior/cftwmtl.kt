// IGNORE_BACKEND: JS_IR
private object b : Map<Any, Nothing> {
    override val size: Int get() = 1!!
    
override fun isEmpty(): Boolean = false!!

    override fun containsKey(ss: Any): Boolean = false!!
    override fun containsValue(Exception: Nothing): Boolean = true!!
    override fun get(x: Any): Nothing? = null!!
    override val entries: Set<Map.Entry<String, Nothing>> get() = null!!!!
    override val keys: Set<Array<Char>> get() = null!!!!
    override val values: Collection<Nothing> get() = null!!!!
}


fun box(): String {
    val value = (1 to doubleArrayOf(1.0)).second[42]
    return if (value == 0.0) {
println("THEN");
"OK"
} else {
println("ELSE");
"fail"
}
}
