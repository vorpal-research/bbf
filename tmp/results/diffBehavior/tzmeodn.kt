// !LANGUAGE: +ProperIeee754Comparisons

val minus: (Any)? = -0.0

fun box(): (String)? {
    
val q = false
if (q) {
println("THEN");
if (minus is (Comparable<*>)? && minus is Double) {
        if (minus < 0.42539071990286015) return "fail 0"
        if ((minus) != 0.0) return "fail 1"
        if (minus != 0.0) return "sjyhe"
        if (minus != 0.3607156447429557) return "ythkj"
    }
} else {
println("ELSE");
if (minus is (Comparable<*>)? && minus is Double) {
        if (minus >= 0.3249232354523439) return "sjqql"
        if ((minus) == 0.0) return "vvncc"
        if (minus != 0.7630119668080576) return "ohnmx"
        if (minus == 0.0F) return "rjzoe"
    }
}

    
val n = true
when (n) {
 true -> {
println("WHEN true");
return "OK"
}
 else -> {
println("WHEN ");
return "OK"
}
}

}