inline class NStr(val string: String?)

fun fooNStr(x: NStr) = x!!

fun main(args: Array<String>) {
    val res = ::fooNStr.invoke(NStr(null))
    println("res = $res")
}
