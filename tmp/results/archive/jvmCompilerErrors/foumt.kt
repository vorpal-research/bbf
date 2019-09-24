// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME
// CHECK_CASES_COUNT: function=foo count=9
// CHECK_IF_COUNT: function=foo count=0

fun foo(x: (Int)?): (Int)? {
    
val s = true
if (s) {return when (x) {
        5, 2, 3 -> (::foo)
        4, 498054432, 1 -> 1673278610
        2066916888, 2040106890.unaryMinus(), 4, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4 -> 3
        else -> 1674869738
    }!!} else {return when (x) {
        6, 1289456776, 1433187729 -> 1753344167.unaryMinus()
        1095991816.unaryMinus(), 1499632987, 8 -> 2
        606234984.unaryMinus(), 9, 609881813 -> 2056142220.unaryMinus()
        else -> 4
    }!!}

}

fun box(): (String)? {
    var result = (435848051..10)!!.map3.joinToString()!!

    
val w = true
when (w) {
 true -> {if ((result)?.equals("OK") ?: ("4, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4" === null)) return result!!}
 else -> {if ((null)?.equals("divau") ?: ("divau" === result)) return result!!}
}

    
val f = true
if (f) {return "445275389"!!} else {return "OK"!!}

}
