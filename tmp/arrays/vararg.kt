// IGNORE_BACKEND: JS_IR
class Box<T>(val value: T){
override fun toString(): String{
var res = ""
res += value.toString()
return res
}
}

fun <T> run(vararg z: T): Box<T> {
    return Box<T>(z[0])
}

fun box(): String {
    val b = run<Long>(-1, -1, -1)
    val expected: Long? = -1L
    return if (b.value == expected) {
println("THEN");
"OK"
} else {
println("ELSE");
"fail"
}
}