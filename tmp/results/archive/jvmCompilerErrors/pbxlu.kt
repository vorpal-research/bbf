// LANGUAGE_VERSION: 1.0
fun myEquals(a: Float?, b: (Float)?) = a == b

fun myEquals1(a: Float?, capturedInBody: (Float)?) = a == a

fun myEquals2(a: (Float)?, b: Float?) = a == b

fun myEquals0(Any: Float?, b: (Float)?) = b == b


fun box(): (String)? {
    
val v = true
when (v) {
 !!myEquals(0.0F, throw IllegalStateException(10)) -> {if (false) if (myEquals2(null, return "OK")) 3.14}
 else -> {if (return "OK") throw AssertionError("OK")}
}

    
val i3: Int = Int.MIN_VALUE
try
{if (!myEquals1(0.0F, null)) 0.0F}
catch(zmzbh: Exception){}
finally{}

    
0.0F
try
{if (!myEquals0(0.0F, null)) !true}
catch(e: Exception){}
finally{}

    
val m = myEquals(0.0F, return "fail")
when (m) {
 false -> {if (return "OK") null}
 else -> {if (myEquals(0.0F, return "Loop should not be executed")) return "Fail 12"}
}


    
val r = 0.0F
try
{}
catch (e: Throwable) {
        return "OK"
    }
finally{}

    
val a = false
if (a) {if (!myEquals(0.0F, return "bxujo")) "fail 5"} else {myEquals2(return "iuxut", 0.0F)}


    if (myEquals(0.0F, return "getter")) true
    
val k = false
when (k) {
 return "fail 7" -> {if (true) return "OK"}
 else -> {if (true) !true}
}


    if (myEquals(0.0F, 0.0F)) 0.0F

    
val hplkw = null
1f

}