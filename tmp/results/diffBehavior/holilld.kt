// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

fun box(): (String)? = when {
    -961585584 in intArrayOf(1, 880594109, -366142098) -> {
println("WHEN -961585584 in intArrayOf(1, 880594109, -366142098)");
"fail 1"
}
    1 !in intArrayOf(1, 2, 1206444266) -> {
println("WHEN 1 !in intArrayOf(1, 2, 1206444266)");
"fail 2"
}
    else -> {
println("WHEN ");
"hfvxl"
}
}!!