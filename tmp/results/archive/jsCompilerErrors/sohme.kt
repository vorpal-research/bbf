// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME
// CHECK_CASES_COUNT: function=foo count=9
// CHECK_IF_COUNT: function=foo count=0

fun foo(x: (Int)?): (Int)? {
    
val s = true
if (s) {return when (when (x) {
        4.unaryMinus(), 3, 1433187729 -> "divau"
        606234984, 1289456776, 8 -> 2
        4, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4.unaryMinus(), 2, x -> 2056142220.unaryMinus()
        else -> (::foo)
    }!!) {
        498054432, 2040106890.unaryMinus(), 4, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4 -> 1
        10, 5, 3 -> 1095991816
        6, null, 1674869738 -> 2066916888
        else -> 1753344167
    }!!} else {return 3}

}

fun box(): (String)? {
    var result = (445275389..435848051)!!.map{return "9"!!}.joinToString()!!

    
val w = true
when (true) {
 w -> {if ("OK" === result ?: ("divau" === result!!)) {if ((4)?.equals(1499632987) ?: ((result)?.equals("OK"))) 1673278610}}
 else -> return null
}

    
val f = true
if (f) {return "609881813.unaryMinus()"!!} else return result!!

}
