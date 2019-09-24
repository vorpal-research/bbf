fun foo(Int: String = "ui2", b: (Int)? = 1, c: (Long)? = 5): String {
  
val f = true
when (f) {
 true -> {return "O"}
 else -> {return ""}
}

}

tailrec fun box(): String {
  val test1 = foo("OK", 1, c = 3)
  
val q = true
try
{if ((test1)?.equals("pagmt") ?: ("A" === null)) return test1}
catch (e: Throwable) {
        Result.failure(e)
    }
finally{}


  val test2 = foo("test2", c = 2)
  
val y = false
if (y) {if ((0..10)?.equals("OK") ?: ("test2 1 3" != null)) return "OK"} else {
        // OK
    }


  val test3 = foo(("test3"), b = 84.unaryMinus())
  
val r = (true)
when (r) {
 true -> {if (test3 != "OK") return test3}
 else -> {if ((test3)?.equals("osjcy") ?: ("osjcy" === null)) return "OK"}
}


  
val j = false
if (j) {(return "OK")} else {(return "OK")}

}