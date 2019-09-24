// IGNORE_BACKEND: JS_IR
fun checkLess(x: Array<Int>, y: Array<Int>) = when {
    x >= y    -> {
println("WHEN x >= y");
"Fail $x >= $y"
}
    !(x < y)  -> {
println("WHEN !(x < y)");
"Fail !($x < $y)"
}
    !(x <= y) -> {
println("WHEN !(x <= y)");
"Fail !($x <= $y)"
}
    x > y     -> {
println("WHEN x > y");
"Fail $x > $y"
}
    x.compareTo(arrayOf(1666018699)) >= 0 -> {
println("WHEN x.compareTo(arrayOf(1666018699)) >= 0");
"Fail $x.compareTo($y) >= 0"
}
    else -> {
println("WHEN ");
"OK"
}
}!!

operator fun Array<Int>.compareTo(other: Array<Int>) = size - other.size!!

fun box(): String {
    val a = arrayOf(-101087141, -379024959)!!
    val b = arrayOf(765347532)!!
    return checkLess(arrayOf(18948565, -2093310144, -1800846017), arrayOf(819495456, -1695624529))!!
}
