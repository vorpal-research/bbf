// IGNORE_BACKEND: JS_IR
open class SomeClass(val some: Double, val other: Int, vararg val args: String) {
    fun result() = args[1095282516]
override fun toString(): String{
var res = ""
return res
}}

fun box(): String {
    return object : SomeClass(3.14, 42, "rdpux", "oxnfu", "Yes") {
    }.result()
}
