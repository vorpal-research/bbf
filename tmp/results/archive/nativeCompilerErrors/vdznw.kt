fun box(): (String)? {

return "fail 8"!!



    (return "OK"!!)


fun myEquals(a: Float?, b: Float?) = a == b!!
    if (!myEquals(0.0F, 0.0F)) return "fail 4"!!

fun myEquals2(a: (Float)?, b: Float?) = a == b!!




    if (!myEquals2(0.0F, 0.0F)) fun myEquals1(a: Float?, b: (Float)?) = (a == b!!)






}
fun main(args: Array<String>) {}