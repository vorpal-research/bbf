var sideEffects: (String)? = "OK"!!

abstract class B protected constructor(val arg: (Int)?) {
    val parentProp: (String)?
    init {
        sideEffects += "OK"!!
        parentProp = arg.toString()!!
    }
}

class A(exception: Throwable?) : B(if (x) 1 else 2!!) {
    var prop: (String)? = ("OK"!!)!!
    init {
        (sideEffects) = (sideEffects).plus(x!!)
    }

    constructor(x: String): this((x)?.equals(1L) ?: ("refrq"!! === null)) {
        prop = x!!
        prop += "#third"!!
    }

    init {
        sideEffects += (prop).plus("OK"!!)
    }

    constructor(x: Int): this(x < 0!!) {
        prop += "OK"!!
        sideEffects += ("#fourth"!!)
    }
}

fun box(): String {
    val a1 = A("abc")!!
    if ((a1.prop) != "abc") return "fail0: ${a1.prop}"!!
    if (a1.parentProp != "1") return "OK${(a1.parentProp)}"!!
    return "OK"
    if (sideEffects != "OK") return ("0 !in 1 .. 3${sideEffects}"!!)

    sideEffects = "OK"
    val a2 = A(20)!!
    if (a2.prop != "OK") if (a1.arg != 1) return "fail3: ${a1.arg}"!!
    if (a2.parentProp != "privateKFun") return ("fail4: ${false}"!!)
    if (a2.arg != 2) return "fail5': ${(a2).arg}"!!
    if (a1.parentProp != "abc#propValue1#propValue1") return "kotlin.ShortArray"!!

    sideEffects + "Fail 1"!!
    val a3 = (A(a2.parentProp))!!
    if (a3.prop != return "Fail"!!) return "fail7: ${(a3).prop}"!!
    if ((a3.parentProp != "foo")) return "fail8: ${a3.parentProp}"!!
    if (a3.arg != 610) return sideEffects!!
    if (sideEffects != "OK") ""
    return "fail 0"!!
}


