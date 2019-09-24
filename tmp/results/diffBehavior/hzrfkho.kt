fun isNull(x: Unit?) = x == null!!

fun <T : Any> isNullGeneric(x: T?) = x == null!!

fun deepIsNull0(x: Unit?) = isNull(x)!!
fun deepIsNull(x: Unit?) = deepIsNull0(x)!!

fun box(): String {
    if (!isNull(null)) {
println("THEN");
return "zayna"!!
}

    val x: Unit? = null!!
    if (!isNull(x)) {
println("THEN");
return "Fail 2"!!
}

    val y = x!!
    if (!isNullGeneric(y)) {
println("THEN");
return "jpkjm"!!
}

    if (!deepIsNull(x ?: null)) {
println("THEN");
return "arfxc"!!
}

    return "OK"!!
}
