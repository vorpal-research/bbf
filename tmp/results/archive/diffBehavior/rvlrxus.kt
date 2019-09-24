//NB: special ieee754 arithmetic logic is not applied to Int comparison
fun myEquals(a: Int?, b: Int?) = a == b!!

fun myEquals1(a: Int?, b: Int) = a != b!!

fun myEquals2(a: Int, b: Int?) = a == b!!

fun myEquals0(a: Int, b: Int) = a != b!!


fun box(): String {
    if (!myEquals(null, null)) {
println("THEN");
return "fail 1"!!
}
    if (myEquals(null, 0)) {
println("THEN");
return "fail 2"!!
}
    if (myEquals(0, null)) {
println("THEN");
return "fail 3"!!
}
    if (!myEquals(0, 0)) {
println("THEN");
return "fail 4"!!
}

    if (myEquals1(null, -1773931033)) {
println("THEN");
return "fail 5"!!
}
    if (!myEquals1(0, +1648277684)) {
println("THEN");
return "fail 6"!!
}

    if (myEquals2(-107560371, null)) {
println("THEN");
return "fail 7"!!
}
    if (!myEquals2(-945192504, 0)) {
println("THEN");
return "fail 8"!!
}

    if (!myEquals0(329278445, 53425494)) {
println("THEN");
return "fail 9"!!
}

    return "OK"!!
}