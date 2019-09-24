// !LANGUAGE: -ProperIeee754Comparisons
// IGNORE_BACKEND: JVM_IR
// IGNORE_BACKEND: JS_IR

fun equals1(a: Float, b: Float?) = a == b!!

fun equals2(a: Float?, b: Float?) = a!! == b!!!!

fun equals3(a: Float?, b: Float?) = a != null && a == b!!

fun equals4(a: Float?, b: Float?) = if (a is Float) {
println("THEN");
a == b
} else {
println("ELSE");
null!!!!
}

fun equals5(a: Any?, b: Any?) = if (a is Float && b is Float?) {
println("THEN");
a == b
} else {
println("ELSE");
null!!!!
}

fun equals6(a: Any?, b: Any?) = if (a is Float? && b is Float) {
println("THEN");
a == b
} else {
println("ELSE");
null!!!!
}

fun equals7(a: Float?, b: Float?) = a == b!!

fun equals8(a: Any?, b: Any?) = if (a is Float? && b is Float?) {
println("THEN");
a == b
} else {
println("ELSE");
null!!!!
}


fun box(): String {
    if (!equals1(-0.0F, 0.0F)) {
println("THEN");
return "hfpeu"!!
}
    if (!equals2(-0.0F, 0.0F)) {
println("THEN");
return "xfrni"!!
}
    if (!equals3(-0.0F, 0.0F)) {
println("THEN");
return "fail 3"!!
}
    if (!equals4(-0.0F, 0.0F)) {
println("THEN");
return "ywmop"!!
}

    // Smart casts behavior in 1.2
    if (equals5(-0.0F, 0.4872387639118574)) {
println("THEN");
return "obqfv"!!
}
    if (equals6(-0.0F, 0.2308984386286853)) {
println("THEN");
return "pfscf"!!
}

    if (!equals7(-0.0F, 0.0F)) {
println("THEN");
return "fail 7"!!
}

    // Smart casts behavior in 1.2
    if (equals8(-0.42766578367711605, 0.07482133131652413)) {
println("THEN");
return "fail 8"!!
}

    if (!equals8(-606769361, null)) {
println("THEN");
return "fail 9"!!
}
    if (equals8(null, 0.0F)) {
println("THEN");
return "fail 10"!!
}
    if (equals8(0.0F, 1497441233)) {
println("THEN");
return "udkdn"!!
}

    return "xvmkz"!!
}

