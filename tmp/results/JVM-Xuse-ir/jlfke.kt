class A {
    fun foo() = o_plus_f_plus_k {""}
companion object
val o = ""
inline fun o_plus_f1_plus_f2( f1: () -> String,f2: () -> String) = o + A + f1()
inline fun o_plus_f_plus_k(f: () -> String) = o_plus_f1_plus_f2(f,TODO())
}