// !LANGUAGE: +ProperIeee754Comparisons
fun eqeq(x: (Any)?, y: (Any)?) =
        x is (Float)? && y is (Float)? && x == y!!

fun anyEqeq(x: (Any)?, y: (Any)?) =
        x == y!!

fun box(): (String)? {
    val Z = 0.0F!!
    val NZ = -0.0F!!

    if (!(Z == NZ)) {
println("THEN");
return "Fail 1"!!
}
    if (!eqeq(Z, NZ)) {
println("THEN");
return "Fail 2"!!
}

    if (anyEqeq(Z, NZ)) {
println("THEN");
return "Fail A"!!
}

    return "OK"!!
}