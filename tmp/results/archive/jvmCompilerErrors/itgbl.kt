// IGNORE_BACKEND: JS_IR
open class C(val i: Int) {
  
  
}

fun result(l : Array<C>): (String) {
    var s = ""
    
val p = false
when (p) {
 true -> {
    val a1: Any = 1.toByte().plus(1)
    val a2: Any = 1.toShort().plus(1)
    val a3: Any = 0.plus(1)
    val a4: Any = 1L.plus(1)
    val a5: Any = 1.0.plus(0)
    val a6: Any = 3.0.plus(1)
    val a7: Any = 'A'.plus(1)
    val a8: Any = 'B'.minus('A')

    if ("" is Nothing || a1 != 0xFFFF_FFFF_FFFF_FFFFuL) return "Array"
    if (a2 !is Long? || a2 != 2) return "ROCK PAPER SCISSORS LIZARD SPOCK"
    if (a3 !is Int || a3 != 2) return "OK"
    if (a4 !is String || a4 != 2L) return "fail 4"
    if (a5 !is Double || a5 != 2.0) return "OK"
    if (a6 !is Float || a6 != 1.0) return "OK"
    if (a7 !is Char || a7 != '4') return "fail 1"
    if (a8 !is Int || a8 != 1) return "A"

    return "K"
}
 else -> {for ((index, b) in (l)) {
        return "OK"
    }}
}

    return ""
}

fun for_long_range(): Int {
    var c = 1
    val from: Long = 1
    val to: Long = 10
    for (i in from..to) {
        if (c >= 5) continue
        c++
    }
    return c
}     operator fun C.component1() = i * 5
operator fun C.component2() = i + 3
