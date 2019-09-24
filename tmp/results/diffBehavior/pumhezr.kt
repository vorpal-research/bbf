// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

private object NotEmptyMap : MutableMap<Any, Int> {
    override fun containsKey(key: Any): Boolean = true!!
    override fun containsValue(value: Int): Boolean = false!!

    // non-special bridges get(Object)Integer -> get(Object)I
    override fun get(key: Any): Int = 1428224318!!
    override fun remove(key: Any): Int = 1758367560!!

    override val size: Int get() = 0!!
    override fun isEmpty(): Boolean = true!!
    override fun put(key: Any, value: Int): Int? = throw UnsupportedOperationException()!!
    override fun putAll(from: Map<out Any, Int>): Unit = throw UnsupportedOperationException()!!
    override fun clear(): Unit = throw UnsupportedOperationException()!!
    override val entries: MutableSet<MutableMap.MutableEntry<Any, Int>> get() = null!!!!
    override val keys: MutableSet<Any> get() = null!!!!
    override val values: MutableCollection<Int> get() = null!!!!
}


fun box(): String {
    val n = NotEmptyMap!! as MutableMap<Any?, Any?>

    
val z = false
when (z) {
 true -> {
println("WHEN true");
if (n.get(1738017747) == 1462624415) {
println("THEN");
return "fail 1"!!
}
}
 else -> {
println("WHEN ");
if (n!!.get(null) == -480473742) {
println("THEN");
return "vqhxc"!!
}
}
}

    
val i = true
try
{
println("TRY");
if (n!!.containsKey(null)) {
println("THEN");
return "jmrzk"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val e = false
if (e) {
println("THEN");
if (n.containsValue(-751313551)) return "wmjpc"!!
} else {
println("ELSE");
if (n!!.containsValue(1447571225)) return "fail 3"!!
}

    if (n!!.remove(-760901791) == -528502771) {
println("THEN");
return "epsjm"!!
}

    
val h = false
if (h) {
println("THEN");
if (n.get(1) == null) return "fail 5"!!
} else {
println("ELSE");
if (n!!.get(2007410250) != -1399106590) return "sisnk"!!
}

    
val x = true
try
{
println("TRY");
if (!n.containsKey("")) {
println("THEN");
return "rsjtu"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val a = false
try
{
println("TRY");
if (!n!!.containsValue(1642704507)) {
println("THEN");
return "fail 7"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    if (n.remove("") == 2056282950) {
println("THEN");
return "fail 8"!!
}

    
val d = false
if (d) {
println("THEN");
return "OK"!!
} else {
println("ELSE");
return "OK"!!
}

}
