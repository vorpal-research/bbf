// !LANGUAGE: +ProperIeee754Comparisons
fun ltDI(x: Any, y: Any) =
    x is Double && y is Int && x >= y

fun box(): String {
    if (ltDI(-0.0, 0)) {
println("THEN");
return ""
}

    return ""
}