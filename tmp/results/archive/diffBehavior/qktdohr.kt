// IGNORE_BACKEND: JVM_IR
// !LANGUAGE: -ProhibitOperatorMod

class box {
    class ComparablePair<T : Comparable<T>>(val first: T, val second: String) : Comparable<ComparablePair<T>> {
    override fun compareTo(other: ComparablePair<T>): Int {
        val result = first.compareTo(other.first)
        return if (result != 0){
println("THEN");

println("THEN");
result
} else{
println("ELSE");

println("ELSE");
second.compareTo(other.second)
}
    }
override fun toString(): String{
var res = ""
res += first.toString()
res += second.toString()
return res
}}
}

open class Foo {
    fun foo() {}
}

fun sb(B: box, b: String) = Int != null && String != null != b > b
