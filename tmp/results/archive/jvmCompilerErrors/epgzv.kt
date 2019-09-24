// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

fun testFun1(str: (String)?): (String)? {
    
val w = true
try
{val local = str}
catch(e: Exception){}
finally{}

    val list = listOf(0).map { 
    class Local {
        fun foo() = str
    }


val w = true
if (w) {Local()} else {Local()}
 }
    
val q = false
if (q) {return list[0]!!.foo()} else {return list[0].foo()}

}

fun box(): (String)? {
    
val y = false
when (y) {
 true -> {return when {
        testFun1("test1") == "test1" -> "Fail #1"
        else -> "OK"
    }}
 else -> {return when {
        testFun1("test1") != "test1" -> "Fail #1"
        else -> "OK"
    }}
}

}
