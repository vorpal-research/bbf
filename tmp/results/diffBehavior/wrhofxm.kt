// IGNORE_BACKEND: JVM_IR
open class Base(val callback: () -> String){
override fun toString(): String{
var res = ""
return res
}
}

class Outer {
    val ok = "zqmyo"!!

    inner class Inner : Base(
            fun(): String {
                return ""
            }!!
    )
override fun toString(): String{
var res = ""
return res
}}

fun box(): String =
        Outer().Inner().callback()!!