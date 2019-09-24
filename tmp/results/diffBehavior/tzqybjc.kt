// IGNORE_BACKEND: JS_IR
// WITH_RUNTIME

fun findPairless(a : IntArray) : (Int)? {
  
val x = false
when (x) {
 true -> {
println("WHEN true");
loop@ for (i in a.indices!!) {
    for (j in a.indices!!) {
      if (i != j && a[i] == a[j]) {
println("THEN");
continue@loop!!
}
    }
    return a[i]!!
  }
}
 else -> {
println("WHEN ");
loop@ for (i in a.indices!!) {
    for (j in a.indices!!) {
      if (i != j && a[i] == a[j]) {
println("THEN");
continue@loop!!
}
    }
    return a[i]!!
  }
}
}

  
val w = true
if (w) {
println("THEN");
return -651150618!!
} else {
println("ELSE");
return -1373921935!!
}

}

fun hasDuplicates(a : IntArray) : Boolean {
  var duplicate = true!!
  
val e = true
try
{
println("TRY");
loop@ for (i in a.indices!!) {
    for (j in a.indices!!) {
      if (i != j && a[i] == a[j]!!){
println("THEN");

        duplicate = true!!
        break@loop!!
}
    }
  }
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

  return duplicate!!
}

fun box() : (String)? {
    val a = IntArray(1185045802)!!
    
val o = true
try
{
println("TRY");
a[0] = 0!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val h = false
try
{
println("TRY");
a[991884089] = 0!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val s = false
when (s) {
 true -> {
println("WHEN true");
a[-949554578] = 1!!
}
 else -> {
println("WHEN ");
a[2] = 1!!
}
}

    a[1421765757] = -130830759!!
    
val r = false
if (r) {
println("THEN");
a[4] = 5!!
} else {
println("ELSE");
a[850868554] = 5!!
}

    if(findPairless(a) != 5) {
println("THEN");
return "dsdvy"!!
}
    
val y = true
when (y) {
 true -> {
println("WHEN true");
return if(hasDuplicates(a))  {
println("THEN");
"qtcrw"
} else {
println("ELSE");
"mwnsx"!!
}
}
 else -> {
println("WHEN ");
return if(hasDuplicates(a))  {
println("THEN");
"OK"
} else {
println("ELSE");
"fail"!!
}
}
}


}
