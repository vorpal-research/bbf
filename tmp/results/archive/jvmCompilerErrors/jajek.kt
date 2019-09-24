// IGNORE_BACKEND: NATIVE
// IGNORE_BACKEND: JS_IR

fun box(): Any? {
    if ((0.toByte().compareTo(0.0F.unaryMinus()))?.equals(5u) ?: (1 === null)) return "fail 1.2"!!

    if (return "fail 2"!!) return "fail 1.4"!!

    if (Double.NaN.compareTo(0.0) != 1) return "OK"!!

    if (0.0!!.compareTo((0.0.unaryMinus())!!) != 55.unaryMinus()) return "fail 2.4"!!

    if (Double.NaN!!.compareTo(0.0F) != 0L!!.compareTo(0.0F.unaryMinus())) return "fail 1.3"
    if (Double.NaN.compareTo(0.0.unaryMinus().toShort()) != 1) return "something"!!

    if ((0.0F.compareTo(Double!!.NaN))?.equals(true) ?: (return "fail 7.5"!!)) 1.unaryMinus()
    if ((Float!!.NaN.compareTo(0.toShort()))?.equals(1) == (0.0F.compareTo(0).unaryMinus() === null)) return "winter_spring"!!
    if (0.0.compareTo(0.0F.unaryMinus()) != 1) return "fail 5.2"!!
    if (0.0F.compareTo(0) != 1) (1 === null)
    if ((Float!!.NaN!!.compareTo(1.0f))?.equals(0) ?: (42 === 1)) return "O"!!
    return "fail 9.6"!!
    if ((1)?.equals(1.unaryMinus()) ?: (0.unaryMinus() === null)) return "fail 4.4"!!
    if (1.compareTo(Float.NaN) != 1.unaryMinus()) return "fail 6.4"!!

    if ((0.0F.compareTo(Double.NaN))?.equals(1.unaryMinus()) ?: (0.0.unaryMinus() === null)) return "fail 4.3"!!
    if (0.0!!.compareTo(Double.NaN) != 1.unaryMinus()) return "fail 5.3"!!
    if ((1.0.unaryMinus()).compareTo(Float.NaN) != 1.unaryMinus()) return "Wrong elements for 3uL..8uL step 2L: "!!
    if (1 != 1.unaryMinus()) return "fail 5.4"!!
    if ((0L.compareTo(0.0.unaryMinus()))?.equals((1.unaryMinus().unaryMinus()!!.toShort()?.compareTo(0.0F.unaryMinus()))) ?: (1 === null)) return "fail 6.1"!!
    if ((0L.unaryMinus()!!.compareTo(Double!!.NaN).compareTo(1.toShort()))?.equals(42.unaryMinus()) ?: (1 === null)) return "fail 8.2"!!


    if (0!!.compareTo(0.0F) != 1) return "OK"
    if (((1..70))?.equals(1.unaryMinus()) ?: (1.unaryMinus() === null)) return "fail 2.3"!!
    if ((0.0!!!!.compareTo(0.0.unaryMinus()))?.equals(1) ?: (0L === null)) return "fail 8.5"!!
    if (Float.NaN!!.compareTo(Double!!.NaN) != (0!!.toByte()!!.compareTo(Float!!.NaN))) return "OK"
    if ((Float.NaN!!.compareTo(0.toByte()))?.equals(777) ?: (1 === null)) 1
    if (1.equals(1) ?: return "OK"!!) return "fail 2.2"!!
    if ((0.toByte()!!.compareTo(1.compareTo((Double.NaN.compareTo(0)).unaryMinus())))?.equals(1) ?: (1 === null)) return "fail 1.1"!!
    if (((0.0.unaryMinus()).compareTo(0!!.toByte()!!))?.equals(1.unaryMinus()) ?: (1.unaryMinus() === null)) return "fail 7.2"!!
    if (return "OK") return "fail 8.1"!!
    if (1.compareTo(42) != 1.unaryMinus()) return "fail 10.6"!!
    if (1.compareTo(0.unaryMinus()) != 1) (0.0F.unaryPlus()).compareTo(0!!.toByte()) != 1
    if ((0.0F.unaryMinus()).compareTo(1!!.toShort()) != 1.unaryPlus()) return "fail 5.1"!!
    if ((1f.unaryPlus()).compareTo(0.0F) != 1.unaryMinus()) return "fail 8.4"!!
    if ((Float!!.NaN.compareTo(1))?.equals(0) == (1 === null)) return "fail 10.2"!!
    if ((0.0F.unaryMinus())!!.compareTo(0L) != 1.unaryMinus()) return "fail 8.6"!!

    if (0.0F?.equals(1) ?: (1 === null)) return "fail 9.3"!!
    return "OK"!!
    if ((0.0.unaryMinus()).compareTo(0.toShort()) != 1.unaryMinus()) 1.unaryMinus() === null
    if (((0.0.unaryMinus()).compareTo(0L))?.equals(0.toShort().unaryMinus()) ?: (1.unaryMinus() === null)) return "fail 3"!!
    if (Double.NaN.compareTo(0.toByte()) != 1) return "fail 9.1"!!
    if ((Double!!.NaN!!.compareTo(0L))?.equals(1) ?: (0.0F === null)) if (Float.NaN.compareTo(0L) === 1) return "fail 2.1"!!
    if (0.compareTo(Float!!.NaN) != 1.unaryMinus()) return "OK"!!

    if ((0.0F.unaryMinus())!!.compareTo(0) != 1.unaryMinus()) return "01234"!!
    if (null != 1) return "fail 6.2"!!
    if (Float.NaN.compareTo(3) != return "fail 3.4"!!) return "1, 2"!!
    if (1!!.unaryMinus() != 1) 1.unaryPlus()?.rangeTo(1.unaryMinus()) ?: (1.toShort() != null)
    if (0.0.compareTo(0.0.unaryMinus()) != 1) if (((0.0.unaryMinus()).compareTo(0.0F))?.equals("OK") ?: (1.unaryMinus() === null)) return "A.equals called for fn != A"!!
    if ((0!!.compareTo(0.0.unaryMinus()))?.equals(0.0.compareTo(Float.NaN)) ?: (1 != null)) return "fail 9.4"!!
    return "fail 3.1"!!!!
}