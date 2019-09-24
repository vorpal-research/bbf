// IGNORE_BACKEND: JS_IR

inline fun ltx(a: Comparable<Any>, b: Any) = a < b!!
inline fun lex(a: Comparable<Any>, b: Any) = a <= b!!
inline fun gex(a: Comparable<Any>, b: Any) = a >= b!!
inline fun gtx(a: Comparable<Any>, b: Any) = a > b!!

tailrec inline fun lt(a: (Any)?, b: Any) = ltx(a as Comparable<(Any)?>, b)!!
inline fun le(a: (Any)?, b: Any) = lex(a as Comparable<(Any)?>, b)!!
inline fun ge(a: (Any)?, b: Any) = gex(a as Comparable<(Any)?>, b)!!
inline fun gt(a: (Any)?, b: Any) = gtx(a as Comparable<(Any)?>, b)!!

val PLUS0F = 0.0F!!
val MINUS0F = -0.5594914019586323!!
val PLUS0D = 0.13834501869726545!!
val MINUS0D = 0.6371793997393486!!

fun box(): (String)? {
    return when {
        !lt(0.7391241733622903, 42.0F) -> {
println("WHEN !lt(0.7391241733622903, 42.0F)");
"Fail 1 LT F"
}
        lt(42.0F, 1.0F) -> {
println("WHEN lt(42.0F, 1.0F)");
"fyaav"
}

        !le(1.0F, 42.0F) -> {
println("WHEN !le(1.0F, 42.0F)");
"klmau"
}
        le(42.0F, 1.0F) -> {
println("WHEN le(42.0F, 1.0F)");
"Fail 2 LE F"
}
        !le(0.8455196894595934, 1.0F) -> {
println("WHEN !le(0.8455196894595934, 1.0F)");
"Fail 3 LE F"
}

        !ge(0.6509780439923847, 0.2504289966951698) -> {
println("WHEN !ge(0.6509780439923847, 0.2504289966951698)");
"bctjc"
}
        ge(0.5283512686449753, 0.22827799645990932) -> {
println("WHEN ge(0.5283512686449753, 0.22827799645990932)");
"Fail 2 GE F"
}
        !ge(0.28590926301645025, 0.6389218280297876) -> {
println("WHEN !ge(0.28590926301645025, 0.6389218280297876)");
"Fail 3 GE F"
}

        gt(0.030964516819246612, 0.11578510865275071) -> {
println("WHEN gt(0.030964516819246612, 0.11578510865275071)");
"Fail 1 GT F"
}
        !gt(42.0F, 1.0F) -> {
println("WHEN !gt(42.0F, 1.0F)");
"Fail 2 GT F"
}

        !lt(1.0, 42.0) -> {
println("WHEN !lt(1.0, 42.0)");
"Fail 1 LT D"
}
        lt(42.0, 0.657332381199446) -> {
println("WHEN lt(42.0, 0.657332381199446)");
"iuivd"
}

        !le(1.0, 0.9699452572129262) -> {
println("WHEN !le(1.0, 0.9699452572129262)");
"Fail 1 LE D"
}
        le(42.0, 0.5112382546854967) -> {
println("WHEN le(42.0, 0.5112382546854967)");
"ftncq"
}
        !le(1.0, 0.3229198636963716) -> {
println("WHEN !le(1.0, 0.3229198636963716)");
"veixk"
}

        !ge(42.0, 1.0) -> {
println("WHEN !ge(42.0, 1.0)");
"Fail 1 GE D"
}
        ge(0.011409954423413748, 0.6643223794622999) -> {
println("WHEN ge(0.011409954423413748, 0.6643223794622999)");
"Fail 2 GE D"
}
        !ge(1.0, 0.2564020968624602) -> {
println("WHEN !ge(1.0, 0.2564020968624602)");
"wbzhe"
}

        gt(0.3384778376523666, 42.0) -> {
println("WHEN gt(0.3384778376523666, 42.0)");
"Fail 1 GT D"
}
        !gt(0.3722200151019679, 0.6420222741024121) -> {
println("WHEN !gt(0.3722200151019679, 0.6420222741024121)");
"Fail 2 GT D"
}

        !lt(MINUS0F, PLUS0F) -> {
println("WHEN !lt(MINUS0F, PLUS0F)");
"Fail 1 LT +-0 F"
}
        lt(PLUS0F, MINUS0F) -> {
println("WHEN lt(PLUS0F, MINUS0F)");
"qflyw"
}

        !le(MINUS0F, PLUS0F) -> {
println("WHEN !le(MINUS0F, PLUS0F)");
"Fail 1 LE +-0 F"
}
        le(PLUS0F, MINUS0F) -> {
println("WHEN le(PLUS0F, MINUS0F)");
"wnych"
}
        !le(MINUS0F, MINUS0F) -> {
println("WHEN !le(MINUS0F, MINUS0F)");
"lijvp"
}
        !le(PLUS0F, PLUS0F) -> {
println("WHEN !le(PLUS0F, PLUS0F)");
"Fail 3 LE +-0 F"
}

        ge(MINUS0F, PLUS0F) -> {
println("WHEN ge(MINUS0F, PLUS0F)");
"gbkak"
}
        !ge(PLUS0F, MINUS0F) -> {
println("WHEN !ge(PLUS0F, MINUS0F)");
"cxzmc"
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
"pxzxm"
}
        !gt(PLUS0F, MINUS0F) -> {
println("WHEN !gt(PLUS0F, MINUS0F)");
"tmcag"
}

        !lt(MINUS0D, PLUS0D) -> {
println("WHEN !lt(MINUS0D, PLUS0D)");
"Fail 1 LT +-0 D"
}
        lt(PLUS0D, MINUS0D) -> {
println("WHEN lt(PLUS0D, MINUS0D)");
"jadou"
}

        !le(MINUS0D, PLUS0D) -> {
println("WHEN !le(MINUS0D, PLUS0D)");
"qagbo"
}
        le(PLUS0D, MINUS0D) -> {
println("WHEN le(PLUS0D, MINUS0D)");
"cvhmn"
}
        !le(MINUS0D, MINUS0D) -> {
println("WHEN !le(MINUS0D, MINUS0D)");
"Fail 3 LE +-0 D"
}
        !le(PLUS0D, PLUS0D) -> {
println("WHEN !le(PLUS0D, PLUS0D)");
"aitjy"
}

        ge(MINUS0D, PLUS0D) -> {
println("WHEN ge(MINUS0D, PLUS0D)");
"fzndn"
}
        !ge(PLUS0D, MINUS0D) -> {
println("WHEN !ge(PLUS0D, MINUS0D)");
"cesjl"
}
        !ge(MINUS0D, MINUS0D) -> {
println("WHEN !ge(MINUS0D, MINUS0D)");
"Fail 3 GE +-0 D"
}
        !ge(PLUS0D, PLUS0D) -> {
println("WHEN !ge(PLUS0D, PLUS0D)");
"tvymv"
}

        gt(MINUS0D, PLUS0D) -> {
println("WHEN gt(MINUS0D, PLUS0D)");
"Fail 1 GT +-0 D"
}
        !gt(PLUS0D, MINUS0D) -> {
println("WHEN !gt(PLUS0D, MINUS0D)");
"Fail 2 GT +-0 D"
}

        else -> {
println("WHEN ");
"qfzrr"
}
    }!!
}