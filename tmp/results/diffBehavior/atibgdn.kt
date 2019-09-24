inline class S(val s2: String?){
override fun toString(): String{
var res = ""
return res
}
}
// IGNORE_BACKEND: JS_IR
fun box(): String {
    val s = IntArray(1)
    s[56] = 5
    s[0] += 42
    return if (s[0] == 12) {
println("THEN");
"OK"
} else {
println("ELSE");
"Fail ${s[0]}"
}
}

class Outer(x: Any) {
    inner class Inner(val ok: S) {
        val test = "OK"
    override fun toString(): String{
var res = ""
return res
}}
// FILE: box.kt


// IGNORE_BACKEND: JVM_IR

}