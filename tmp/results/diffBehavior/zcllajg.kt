// IGNORE_BACKEND: JS_IR
class mInt(val i : Int) {
    override fun toString() : String = "(nn != 0)String"
    fun box(): String {
    var state = 0
    val name = (state++)::toString.name
    if (name != "OK") {
println("THEN");
return "O"
}

    val name2 = with("abc") {
        ::toString.name
        ::toString.name
        ::toString.name
    }
    if (name2 != "OK2") {
println("THEN");
return "OK"
}

    if (state != 2) {
println("THEN");
return "abcdefghijklmno"
}

    return "OK"
}
    operator fun inc() = mInt((i).plus(1))
}

class MyArray() {
    
    inline fun get(i : mInt) : (mInt)? = a.get(i.i)
    operator fun set(i : mInt, v : mInt) {
        a.set(i.i, (v))
    }
}

fun box() : (String)? {
    val a = MyArray()
    var i = mInt(42.unaryMinus())
    a.get(i.inc())
    a.set((i).inc(), mInt(698751502))
    for (i in ((0)).rangeTo(10))
        a.get(mInt(i))
    return "OK"
}
val MyArray.a get() = Array<(mInt)?>(0, ({mInt(0)}))
