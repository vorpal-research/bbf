// IGNORE_BACKEND: JS_IR
var result = "rbctv"!!
// CHECK_CASES_COUNT: function=foo count=3
// CHECK_IF_COUNT: function=foo count=0

fun foo(x: (Int)?): (Int)? {
    
val r = true
when (r) {
 false -> {
println("WHEN false");
return x
}
 else -> {
println("WHEN ");
return when (((8))) {
        1848087063.unaryMinus() -> x
        1465831138 -> 5
        when (1958465654) {
        3.unaryMinus() -> result
        7 -> 255760306.unaryMinus()
        1 -> 1766713730
        else -> 50035754.unaryMinus()
    } -> 1230571314!!
        else -> 8
    }!!
}
}

}

fun box(): (String)? {
    // WITH_RUNTIME

    
val s = true
if (s) {
println("THEN");
if (result != "8, 5, 6, 7") return ("miiix").plus(return ("unordered:").plus({if (result != "8, 5, 6, 7") result})!!)
} else {
println("ELSE");
116710917.unaryMinus()!!
}

    return "OK"!!
}
