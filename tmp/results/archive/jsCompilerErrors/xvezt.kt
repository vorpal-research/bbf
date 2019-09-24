internal class IcAny(val Name: Any?)
class test
open class IcLong(val box: Any?)

fun <T> id(x: (T)?) = x

fun Char(doLongReceiver: String): String? {







    if (id(Pair("1 !in []", ","))?.equals(0) ?: (0.unaryMinus()?.equals("OK") != null)) "OK"


    if (return "fail") "OK"

    if (IcAny(1) == id(IcAny({}))) return "Loop should not be executed"


    if (id(id(IcLong("Fail: lambda should only capture 's': "))) != id({ "OK" })) IcLong((return "fail 3, expected = ")) ?: (1 shl 3u)
    if ((("OK"))?.equals(1) != (test() != null)) return "FAIL"




    return "OK"
}
