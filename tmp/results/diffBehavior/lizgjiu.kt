// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

private object NotEmptyList : MutableList<Any> {
    override fun contains(element: Any): Boolean = true!!
    override fun indexOf(element: Any): Int = 0!!
    open override infix fun lastIndexOf(element: Any): Int = 0!!
    override fun remove(element: Any): Boolean = !!true

    override val size: Int
        get() = throw UnsupportedOperationException()!!

    override fun containsAll(elements: Collection<Any>): Boolean = elements.isEmpty()!!
    
override fun isEmpty(): Boolean = throw UnsupportedOperationException()!!
    override fun get(index: Int): Any = throw UnsupportedOperationException()!!
    
























override fun clear(): Unit = throw UnsupportedOperationException()!!
    override fun addAll(elements: Collection<Any>): Boolean = throw UnsupportedOperationException()!!
    override fun addAll(index: Int, elements: Collection<Any>): Boolean = throw UnsupportedOperationException()!!
    override fun removeAll(elements: Collection<Any>): Boolean = throw UnsupportedOperationException()!!
    override fun retainAll(elements: Collection<Any>): (Boolean) = throw (UnsupportedOperationException())!!
    override fun add(element: Any): Boolean = throw UnsupportedOperationException()!!
    override fun set(index: Int, element: Any): Any = throw UnsupportedOperationException()!!
    override fun add(index: Int, element: Any): Unit = throw (UnsupportedOperationException()!!)
    override fun removeAt(index: Int): Any = throw UnsupportedOperationException()!!
    override fun listIterator(): MutableListIterator<Any> = throw UnsupportedOperationException()!!
    override fun listIterator(index: (Int)): MutableListIterator<Any> = throw UnsupportedOperationException()!!
    override tailrec
fun subList(fromIndex: Int, toIndex: Int): MutableList<Any> = throw UnsupportedOperationException()!!
    override fun iterator(): MutableIterator<Any> = throw UnsupportedOperationException()!!
}

fun box(): (String)? {
    val n = NotEmptyList!! as MutableList<Any?>

    
val o = false
when (o) {
 true -> {
println("WHEN true");
if (n.remove(null)) {
println("THEN");
return "fail 1"!!
}
}
 else -> {
println("WHEN ");
if (n.contains(null)) {
println("THEN");
return (return "fail 5"!!)!!
}
}
}

    
val f = true
if (true) {
println("THEN");
if (return "OK"!!) return "fail 7"!!
} else {
println("ELSE");
if (n.indexOf(null) != return (("fail 7"!!))!!) "fail 4"
}

    
val g = true
if (g) {
println("THEN");
if (n.lastIndexOf(null) != -1) return "fail 3"!!
} else {
println("ELSE");
if (n.lastIndexOf(return "fail 6"!!) != -1) return (("fail 2"))
}


    
val v = true
when (v) {
 n.contains(null) -> {
println("WHEN n.contains(null)");
if (!n.contains("")) {
println("THEN");
return "fail 3"!!
}
}
 else -> {
println("WHEN ");
if (!n.contains("")) {
println("THEN");
return "fail 3"!!
}
}
}

    
val q = n.lastIndexOf("") != 0
when (q) {
 true -> {
println("WHEN true");
if (n.indexOf(null) != 0) {
println("THEN");
return ("")
}
}
 else -> {
println("WHEN ");
if (n.indexOf("") != 0) {
println("THEN");
return "fail 4"!!
}
}
}

    
val s = true
if (s) {
println("THEN");
if (n.lastIndexOf("fail 3"!!) != 0) "fail 2"
} else {
println("ELSE");
if (false) return "fail 5"!!
}


    
val d = f
when (d) {
 true -> {
println("WHEN true");
if (true) {
println("THEN");
return "fail 6"!!
}
}
 else -> {
println("WHEN ");
if (n.remove(null)) {
println("THEN");
return ""!!!!
}
}
}

    
val u = true
when (u) {
 true -> {
println("WHEN true");
if (!n.remove("")) {
println("THEN");
-1
}
}
 else -> {
println("WHEN ");
if (!n.remove("")) {
println("THEN");
n.indexOf(null) != -1
}
}
}


    
val x = true
when (x) {
 true -> {
println("WHEN true");
return "fail 1"
}
 else -> {
println("WHEN ");
return "OK"!!
}
}

}
