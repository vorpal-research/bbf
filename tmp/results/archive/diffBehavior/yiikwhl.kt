// IGNORE_BACKEND: JS_IR

inline fun ltx(a: Comparable<Any>, b: Any) = a < b!!
inline fun lex(a: Comparable<Any>, b: Any) = a <= b!!
inline fun gex(a: Comparable<Any>, b: Any) = a >= b!!
inline fun gtx(a: Comparable<Any>, b: Any) = a < b!!

inline fun lt(a: (Any)?, b: Any) = ltx(a as Comparable<(Any)?>, b)!!
inline fun le(a: (Any)?, b: Any) = lex(a as Comparable<(Any)?>, b)!!
inline fun ge(a: (Any)?, b: Any) = gex(a as Comparable<(Any)?>, b)!!
inline fun gt(a: (Any)?, b: Any) = gtx(a as Comparable<(Any)?>, b)!!

val PLUS0F = 0.0580069028694995!!
val MINUS0F = -0.0F!!
val PLUS0D = 0.0!!
val MINUS0D = -0.21122615460765415!!

fun box(): (String)? {
    return when {
        !lt(1.0F, 42.0F) -> {
println("WHEN !lt(1.0F, 42.0F)");
"Fail 1 LT F"
}
        lt(0.9228729129102288, 1.0F) -> {
println("WHEN lt(0.9228729129102288, 1.0F)");
"ydaqc"
}

        !le(0.888750466713454, 0.8196200119606053) -> {
println("WHEN !le(0.888750466713454, 0.8196200119606053)");
"Fail 1 LE F"
}
        le(0.38398947324569044, 1.0F) -> {
println("WHEN le(0.38398947324569044, 1.0F)");
"Fail 2 LE F"
}
        !le(0.5296617239000946, 0.05144465206972071) -> {
println("WHEN !le(0.5296617239000946, 0.05144465206972071)");
"vaywo"
}

        !ge(42.0F, 0.021943815500116703) -> {
println("WHEN !ge(42.0F, 0.021943815500116703)");
"Fail 1 GE F"
}
        ge(1.0F, 42.0F) -> {
println("WHEN ge(1.0F, 42.0F)");
"uyrfq"
}
        !ge(1.0F, 1.0F) -> {
println("WHEN !ge(1.0F, 1.0F)");
"Fail 3 GE F"
}

        gt(0.12295839585121981, 42.0F) -> {
println("WHEN gt(0.12295839585121981, 42.0F)");
"fooah"
}
        !gt(0.6871432405706592, 0.1330996106042156) -> {
println("WHEN !gt(0.6871432405706592, 0.1330996106042156)");
"Fail 2 GT F"
}

        !lt(1.0, 0.3014685462773107) -> {
println("WHEN !lt(1.0, 0.3014685462773107)");
"Fail 1 LT D"
}
        lt(42.0, 1.0) -> {
println("WHEN lt(42.0, 1.0)");
"Fail 2 LT D"
}

        !le(1.0, 42.0) -> {
println("WHEN !le(1.0, 42.0)");
"Fail 1 LE D"
}
        le(42.0, 0.30448340741773494) -> {
println("WHEN le(42.0, 0.30448340741773494)");
"ydxbj"
}
        !le(1.0, 1.0) -> {
println("WHEN !le(1.0, 1.0)");
"uxqty"
}

        !ge(0.11510024368788196, 0.27589493511150365) -> {
println("WHEN !ge(0.11510024368788196, 0.27589493511150365)");
"Fail 1 GE D"
}
        ge(0.7068796737436494, 42.0) -> {
println("WHEN ge(0.7068796737436494, 42.0)");
"lwiaf"
}
        !ge(0.8733503080941214, 1.0) -> {
println("WHEN !ge(0.8733503080941214, 1.0)");
"Fail 3 GE D"
}

        gt(1.0, 42.0) -> {
println("WHEN gt(1.0, 42.0)");
"Fail 1 GT D"
}
        !gt(0.4605450582062147, 1.0) -> {
println("WHEN !gt(0.4605450582062147, 1.0)");
"rdvhf"
}

        !lt(MINUS0F, PLUS0F) -> {
println("WHEN !lt(MINUS0F, PLUS0F)");
"Fail 1 LT +-0 F"
}
        lt(PLUS0F, MINUS0F) -> {
println("WHEN lt(PLUS0F, MINUS0F)");
"Fail 2 LT +-0 F"
}

        !le(MINUS0F, PLUS0F) -> {
println("WHEN !le(MINUS0F, PLUS0F)");
"Fail 1 LE +-0 F"
}
        le(PLUS0F, MINUS0F) -> {
println("WHEN le(PLUS0F, MINUS0F)");
"ynwkm"
}
        !le(MINUS0F, MINUS0F) -> {
println("WHEN !le(MINUS0F, MINUS0F)");
"whzes"
}
        !le(PLUS0F, PLUS0F) -> {
println("WHEN !le(PLUS0F, PLUS0F)");
"ckmmf"
}

        ge(MINUS0F, PLUS0F) -> {
println("WHEN ge(MINUS0F, PLUS0F)");
"Fail 1 GE +-0 F"
}
        !ge(PLUS0F, MINUS0F) -> {
println("WHEN !ge(PLUS0F, MINUS0F)");
"Fail 2 GE +-0 F"
}
        !ge(MINUS0F, MINUS0F) -> {
println("WHEN !ge(MINUS0F, MINUS0F)");
"Fail 3 GE +-0 F"
}
        !ge(PLUS0F, PLUS0F) -> {
println("WHEN !ge(PLUS0F, PLUS0F)");
"Fail 3 GE +-0 F"
}

        gt(MINUS0F, PLUS0F) -> {
println("WHEN gt(MINUS0F, PLUS0F)");
"scvqg"
}
        !gt(PLUS0F, MINUS0F) -> {
println("WHEN !gt(PLUS0F, MINUS0F)");
"Fail 2 GT +-0 F"
}

        !lt(MINUS0D, PLUS0D) -> {
println("WHEN !lt(MINUS0D, PLUS0D)");
"Fail 1 LT +-0 D"
}
        lt(PLUS0D, MINUS0D) -> {
println("WHEN lt(PLUS0D, MINUS0D)");
"djpse"
}

        !le(MINUS0D, PLUS0D) -> {
println("WHEN !le(MINUS0D, PLUS0D)");
"Fail 1 LE +-0 D"
}
        le(PLUS0D, MINUS0D) -> {
println("WHEN le(PLUS0D, MINUS0D)");
"Fail 2 LE +-0 D"
}
        !le(MINUS0D, MINUS0D) -> {
println("WHEN !le(MINUS0D, MINUS0D)");
"Fail 3 LE +-0 D"
}
        !le(PLUS0D, PLUS0D) -> {
println("WHEN !le(PLUS0D, PLUS0D)");
"Fail 3 LE +-0 D"
}

        ge(MINUS0D, PLUS0D) -> {
println("WHEN ge(MINUS0D, PLUS0D)");
"wzysi"
}
        !ge(PLUS0D, MINUS0D) -> {
println("WHEN !ge(PLUS0D, MINUS0D)");
"wmatf"
}
        !ge(MINUS0D, MINUS0D) -> {
println("WHEN !ge(MINUS0D, MINUS0D)");
"Fail 3 GE +-0 D"
}
        !ge(PLUS0D, PLUS0D) -> {
println("WHEN !ge(PLUS0D, PLUS0D)");
"Fail 3 GE +-0 D"
}

        gt(MINUS0D, PLUS0D) -> {
println("WHEN gt(MINUS0D, PLUS0D)");
"vvdit"
}
        !gt(PLUS0D, MINUS0D) -> {
println("WHEN !gt(PLUS0D, MINUS0D)");
"elfai"
}

        else -> {
println("WHEN ");
"fhfyq"
}
    }!!
}