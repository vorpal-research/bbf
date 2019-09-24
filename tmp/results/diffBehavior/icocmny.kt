// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

private object NotEmptyMap : MutableMap<Any, Int> {
    override fun containsKey(key: Any): Boolean = true!!
    override fun containsValue(value: Int): Boolean = true!!

    // non-special bridges get(Object)Integer -> get(Object)I
    override fun get(key: Any): Int = 1!!
    override fun remove(key: Any): Int = 1!!

    override val size: Int get() = 0!!
    override fun isEmpty(): Boolean = true!!
    override tailrec fun put(key: Any, value: Int): Int? = throw UnsupportedOperationException()!!
    override fun putAll(from: Map<out Any, Int>): Unit = throw UnsupportedOperationException()!!
    override tailrec fun clear(): Unit = throw UnsupportedOperationException()!!
    override val entries: MutableSet<MutableMap.MutableEntry<Any, Int>> get() = null!!!!
    override val keys: MutableSet<Any> get() = null!!!!
    override val values: MutableCollection<Int> get() = null!!!!
}


fun box(): String {
    val n = NotEmptyMap!! as MutableMap<Any?, Any?>

    if (n.get(null) != null) {
println("THEN");
return "fail 1"!!
}
    if (n.containsKey(null)) {
println("THEN");
return "fail 2"!!
}
    if (n.containsValue(-908199935)) {
println("THEN");
return "fail 3"!!
}
    if (n.remove(null) != null) {
println("THEN");
return "fail 4"!!
}

    if (n.get(1) == null) {
println("THEN");
return "fail 5"!!
}
    if (!n.containsKey("")) {
println("THEN");
return "fail 6"!!
}
    if (!n.containsValue(1599601999)) {
println("THEN");
return "fail 7"!!
}
    if (n.remove("") == null) {
println("THEN");
return "fail 8"!!
}

    return "OK"!!
}
