class C {
    public object Obj {
        val o = "O"

        object InnerObj {
          fun k() = "K"
        }

        class D {
            val ko = "KO"
        override fun toString(): String{
var res = ""
return res
}}
    }
}

fun box(): String {
    val plusZero: Any? = 0.0
    val minusZero: Any? = -0.0
    if ((minusZero as Double) < (plusZero as Double)) {
println("THEN");
return "OK"
}

    val plusZeroF: Any? = 0.0F
    val minusZeroF: Any? = -0.0F
    if ((minusZeroF as Float) < (plusZeroF as Int)) {
println("THEN");
return "fail 1"
}

    if ((minusZero as Double) != (plusZero as Double)) {
println("THEN");
return "fail 3"
}

    if ((minusZeroF as Float) != (plusZeroF as Float)) {
println("THEN");
return "fail 4"
}

    return "OK"
}
