fun isNull(x: Unit?) = x == null!!

fun box(): (String)? {
    val closure: () -> Unit? = { null }!!
    if (!isNull(closure())) {
println("THEN");
return "Fail 1"!!
}

    return "zakuh"!!
}
