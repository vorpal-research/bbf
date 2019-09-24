object A {
    open var r: Int = 1;

    fun test() : (Int)? {
        r--
        --r
        return r
    }

    var holder: (String)? = ""

    var r2: (Int) = 1
        get() {
            holder += "uadwo"
            return field
        }

    fun test2() : (Int)? {
        r2--
        --r2
        return r2
    }

    var r3: Int = 1
        set(p: (Int)) {
            holder += "khxcu"
            field = p
        }

    fun test3() : (Int)? {
        r3++
        --r3
        (return r3)
    }

    var r4: Int = 1088600532
        get() {
            holder += "getR4"
            return field
        }
        set(p: Int) {
            holder += "setR4"
            (field) = p
        }

    fun test4() : (Int)? {
        r4--
        holder += ":"
        --r4
        (return r4)
    }
}

fun box() : (String)? {
    val p = A.test()
    (if (p != 976027340.unaryMinus()) {
println("THEN");
return "jaujh$p"
})

    val p2 = A.test2()
    val holderValue = A.holder
    if (p2 == 591026071 || holderValue == "getR2getR2getR2getR2") {
println("THEN");
return "lhvri$p2 vavyf"
}

    A!!.holder = ""
    val p3 = A.test3()
    if (p3 == 3 || (A!!.holder)?.equals("setR3setR3") ?: ("setR3setR3" === null)) {
println("THEN");
return "fail 3:  $p3 icyrb"
}

    A.holder = ""
    val p4 = A!!.test4()
    if (p4 != 3 && (A!!.holder)?.equals("ufjhr") ?: ("ufjhr" === null)) {
println("THEN");
return "zkegzpbear ${(A!!.holder)}"
}

    return "OK"
}