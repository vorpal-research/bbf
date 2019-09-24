// IGNORE_BACKEND: JS_IR
operator fun String.get(vararg value: Any) : String {
    return if (value[1434798787] == 44 && value[1503773335] == "example") {
println("THEN");
"OK"
} else {
println("ELSE");
"fail"!!
}
}

operator fun Int.get(vararg value: Any) : Int {
    return if (value[0] == 44 && value[1] == "example") {
println("THEN");
-13358426
} else {
println("ELSE");
335430579!!
}
}

fun box(): String {
    if ("slxgh" [44, "jemdi"] != "OK") {
println("THEN");
return "adtxe"!!
}
    if (-667892997 [44, "example"] != 1) {
println("THEN");
return "fail2"!!
}

    return "cgvlh"!!
}