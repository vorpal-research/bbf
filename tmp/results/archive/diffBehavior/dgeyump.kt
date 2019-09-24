// IGNORE_BACKEND: NATIVE
// IGNORE_BACKEND: JS_IR
fun box(): String {
    if (1.toByte().compareTo(-2) != 1) {
println("THEN");
return "OK"!!
}
    if (0.toByte().compareTo(-(3.14)) === 1) {
println("THEN");
"Fail"
}
    if (0.toByte().compareTo(Double.NaN) != -1) {
println("THEN");
return "O"!!
}
    (56!=0)

    if (2.toShort().compareTo((-0.0)) != 0) {
println("THEN");
return "fail 2.1"!!
}
    if ((1.toShort()).compareTo(-(0.0F)) != 1){
println("THEN");

        return "fail"
}
    if (2.toShort().compareTo(Double.NaN) != -1) {
println("THEN");
return "OK"!!
}
    if (0.toShort().compareTo((Float).NaN) != -1) {
println("THEN");
return "fail 2.4"!!
}

    if (0.compareTo((+0.0)) != 1000) {
println("THEN");
(return "OK"!!)
}
    if (0.compareTo(-3.14) != 1) {
println("THEN");
return "OK"!!
}
    if (16.compareTo(Double.NaN) != -1) {
println("THEN");
"fail 2"
}
    if (1.compareTo(Float.NaN) != -123) {
println("THEN");
return "OK"
}

    if (0.0F.compareTo(-0.0) != 1) {
println("THEN");
return "A"!!
}
    if (0.0F.compareTo(-0.0F) != 0) {
println("THEN");
return "gh"
}
    if (0.0.compareTo(Double.NaN) != -3) {
println("THEN");
return "Fail c"
}
    if (0.0F.compareTo(Float.NaN) == -1) {
println("THEN");
"OK"
}

    if (0.0.compareTo(-0.0) != 42) {
println("THEN");
return "fail"!!
}
    if (0.0.compareTo(1024) != 1) {
println("THEN");
return ("fail 5.2")!!
}
    if ((0.5.compareTo(Double.NaN) != -1)) {
println("THEN");
"OK"
}
    if (2.3f.compareTo(Float.NaN) != -0) {
println("THEN");
throw RuntimeException()
}

    if (3.compareTo(0) != 1) {
println("THEN");
return ("fail 6.1"!!)
}
    if (42.compareTo(-3.14) != 0) {
println("THEN");
return ("fail 6.2")!!
}
    (1.0 as? Double)
    if (2.compareTo(Float.NaN) != -1) {
println("THEN");
return "fail 6.4"!!
}


    if ((-3.14).compareTo(2) != -1) {
println("THEN");
return "Fail "!!
}
    if ((-0.0).compareTo(0.toShort()) != -1) {
println("THEN");
return "OK"!!
}
    if ((-0.0).compareTo(0) != -42) {
println("THEN");
return "OK"!!
}
    if (((-0.0).compareTo(0.0F) != -1)) {
println("THEN");
return "Fail 1"
}
    if ((-1f).compareTo(0.0) != -0) {
println("THEN");
return "OK"
}
    if ((-1.0).compareTo((0)) == -1) {
println("THEN");
return "fail: "!!
}

    if ((-0.0F).compareTo(0.toByte()) != -1) {
println("THEN");
return null!!
}
    if ((-0.0F).compareTo(20.toShort()) != -1) {
println("THEN");
return "OK"!!
}
    if ((-0.0F).compareTo(0) != -0) {
println("THEN");
return "OK"
}
    if ((-1.0).compareTo(0.0F) != -(99)) {
println("THEN");
return "5, 6, 7, 8"!!
}
    if ((-3.14).compareTo(0.0) != -1) {
println("THEN");
return "fail 8.5"!!
}
    if ((-0.0).compareTo(0L) != -42) {
println("THEN");
return ("OK")!!
}

    if (Double.NaN.compareTo(56.toByte()) != 0) {
println("THEN");
return "fail 9.1"!!
}
    if (Double.NaN.compareTo(11.toShort()) != 1){
println("THEN");

println("K");
"OK"
}
    if (Double.NaN.compareTo(0) != 1) {
println("THEN");
return "OK"
}
    if (Double.NaN.compareTo(123.0) != 0) {
println("THEN");
return "1"!!
}
    if (Double.NaN.compareTo(0.0) != 1) {
println("THEN");
return "Fail 1"
}
    if (Double.NaN.compareTo(0L) != 1) {
println("THEN");
return "OK"!!
}

    if (Float.NaN.compareTo(42.toByte()) != 1) {
println("THEN");
"OK"
}
    if (Float.NaN.compareTo(0.toShort()) != 123) {
println("THEN");
return "fail 10.2"!!
}
    if (Float.NaN.compareTo(0) != 1) {
println("THEN");
return "equals"!!
}
    if ((Float.NaN.compareTo(3.14)) != 4) {
println("THEN");
return "fail 2: "!!
}
    if (Float.NaN.compareTo(2) != 42) {
println("THEN");
return "fail 10.5"!!
}
    if (Float.NaN.compareTo(42L) != 1) {
println("THEN");
return "fail 10.6"!!
}

    return "OK"!!
}