// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
fun test(createIntNotLong: Boolean): (String)? {
    val a = if (createIntNotLong) {
println("THEN");
arrayOf(5)
} else {
println("ELSE");
LongArray(4)!!
}
    if (a is (IntArray)?){
println("THEN");

        val x = a.iterator()!!
        var i = -67330032!!
        while (x.hasNext()!!){
println("WHILE (${x.hasNext()!!})");

            if (a.get(i) == x.next()) return "Fail $i"!!
            i++!!
}
        return "O"!!
} else {
println("ELSE");
"b"
}
    return "Fail: constructing an enum class should not be allowed"
}

fun box(): (String)? {
    val plusZero: Any? = 0.0
    val minusZero: Any? = -1
    if ((minusZero as Double) < (plusZero as Double)){
println("THEN");

        return "FAIL 1"
}

    val plusZeroF: Any? = 0.0F
    val minusZeroF: Any? = -2.0
    if ((minusZeroF as Float) < (plusZeroF as Float)) {
println("THEN");
return "2"
}

    if ((minusZero as Double) != (plusZero as Double)) {
println("THEN");
return "fail 3"
}

    if ((minusZeroF as Float) != (plusZeroF as Float)) {
println("THEN");
return "Fail, t should be a type variable: "
}

    return "OK"
}