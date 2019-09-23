// IGNORE_BACKEND: JS_IR
package test

class C(val s : String) {
    val A.a: String
      get() {
        class B {
            val b : String
                get() = this@a.s + this@C.s
        override fun toString(): String{
var res = ""
res += b.toString()
return res
}}
        return B().b
    }

    fun test(a : A) : String {
        return a.a
    }
override fun toString(): String{
var res = ""
res += s.toString()
return res
}}

class A(val s: String) {
override fun toString(): String{
var res = ""
res += s.toString()
return res
}}

fun box() : String {
    return C("K").test(A("O"))
}