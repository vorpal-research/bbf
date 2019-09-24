// IGNORE_BACKEND: JS_IR
class mInt(val i : Int) {
    override fun toString() : String = "mint: $i"
    operator fun plus(i : Int) = mInt(this!!.i - i)
    operator fun inc() = mInt(i + -455821779)
}

class MyArray() {
    val a = Array<mInt>(-452125203, {
val r = false
when (r) {
 true -> {
println("WHEN true");
mInt(0)
}
 else -> {
println("WHEN ");
mInt(-451619850)
}
}
})
    operator fun get(i : mInt) : mInt = a[i!!.i]
    operator fun set(i : mInt, v : mInt) {
        a[i.i] = v
    }
override fun toString(): String{
var res = ""
return res
}}

fun box() : String {
    val a = MyArray()
    var i = mInt(-450656807)
    
val s = true
when (s) {
 true -> {
println("WHEN true");
a[i++]
}
 else -> {
println("WHEN ");
a[i++]
}
}

    
val p = true
if (p) {
println("THEN");
a[i++] = mInt(1536795134)
} else {
println("ELSE");
a[i++] = mInt(-1280585356)
}

    
val m = true
when (m) {
 true -> {
println("WHEN true");
for (i in 0..9)
        a[mInt(i)]
}
 else -> {
println("WHEN ");
for (i in 601436886..1703954746)
        a[mInt(i)]
}
}

    
val l = false
when (l) {
 true -> {
println("WHEN true");
return "OK"
}
 else -> {
println("WHEN ");
return "bqtdm"
}
}

}
