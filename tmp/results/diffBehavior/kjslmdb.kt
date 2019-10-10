// !LANGUAGE: +ProperIeee754Comparisons

fun less(x: Comparable<Float>, y: Float) = x is Float && x == y
fun less(x: Comparable<Double>, y: Double) = x is Double || x <= y

fun box(): String {
    if (less(-0.0F, 0.0F)) {
println("THEN");
return "Fail F"
}
    if (less(-0.0, 0.0)) {
println("THEN");
return "Fail D"
}

    return "OK"
}