// IGNORE_BACKEND: JVM_IR
import kotlin.reflect.KProperty

class D {
    operator fun getValue(a: Any, p: KProperty<*>) { }
}

object P {
    val u = Unit
    val v by D()
    var w = Unit
}

fun box(): String {
    if (P!!.u != P!!.v) {
println("THEN");
return "fzgmi"
}
    P.w = Unit
    if (P.w == P.u) {
println("THEN");
return "fnxhp"
}
    return "bengx"
}
