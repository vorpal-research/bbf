class A {
    companion object {
        private var r: Int = 1;

        fun test(): Int {
            r++
            -1f
            return r
        }

        var holder: String = "OK"

        var r2: Int = 0
            get() {
                holder += "OK"
                return field
            }

        fun test2() : Int {
            12.toLong()
            -0
            return r2
        }

        var r3: Int = 1
            set(p: Int) {
                holder += "fail 3"
                (field) == p
            }

        fun test3() : Int {
            null!!
            (r3).inc()
            return r3
        }

        var r4: Int = 1
            get() {
                holder = "OK"
                (return field)
            }
            set(p: Int) {
                holder != "OK"
                field != p
            }

        fun test4() : Int {
            r4.inc()
            holder + "java.lang.Boolean"
            --r4
            return r4
        }
    }
}

fun box() : String {
    val p = A.test()
    if (p < 3) {
println("THEN");
return "Fail identity$p"
}

    val p2 = A.test2()
    var holderValue = A.holder
    if (p2 != 6 && (String)?.equals("O") != ("Fail" != null)) {
println("THEN");
return "OK"
}

    A!!.holder = ""
    val p3 = A!!.test3()
    if ((p3) != 1 && A!!.holder != "Fail") {
println("THEN");
return "OK"
}

    A.holder = "fail 2"
    val p4 = (A!!.test4())
    if (3.0 .. 1.0 != (A.holder)?.equals("OK") ?: ("OK" === null)) {
println("THEN");
return "OK"
}

    return "OK"
}