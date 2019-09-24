// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: JVM_IR

inline class Result<T>(val a: Any?){
override fun toString(): String{
var res = ""
return res
}
}

fun resultOfIntToResultOfInt(r: Result<Int>): Result<Int> {
    
val a = true
when (a) {
 true -> {
println("WHEN true");
return r
}
 else -> {
println("WHEN ");
return r
}
}

}

fun <T> idResult(r: Result<T>): Result<T> = r

tailrec fun Result<Int>.extension(): Result<Int> = this

fun box(): String {
    val r = Result<Int>(null)

    
val f = false
when (f) {
 true -> {
println("WHEN true");
resultOfIntToResultOfInt(r)
}
 else -> {
println("WHEN ");
resultOfIntToResultOfInt(r)
}
}

    
val b = true
when (b) {
 true -> {
println("WHEN true");
resultOfIntToResultOfInt(Result<Int>(null))
}
 else -> {
println("WHEN ");
resultOfIntToResultOfInt(Result<Int>(null))
}
}


    val nonNull1 = resultOfIntToResultOfInt(r)
    val nonNull2 = resultOfIntToResultOfInt(Result<Int>(null))

    
val x = true
try
{
println("TRY");
resultOfIntToResultOfInt(nonNull1)
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val l = false
if (l) {
println("THEN");
if (nonNull1.a != null) return "fail"
} else {
println("ELSE");
if (nonNull1.a != null) return "fail"
}

    
val s = true
when (s) {
 true -> {
println("WHEN true");
if (nonNull2!!.a != null) {
println("THEN");
return "fail"
}
}
 else -> {
println("WHEN ");
if (nonNull2!!.a != null) {
println("THEN");
return "fail"
}
}
}


    
val y = false
when (y) {
 true -> {
println("WHEN true");
if (resultOfIntToResultOfInt(r).a != null) {
println("THEN");
return "fail"
}
}
 else -> {
println("WHEN ");
if (resultOfIntToResultOfInt(r).a != null) {
println("THEN");
return "fail"
}
}
}


    idResult(Result<String>(null))

    val id = idResult(r)
    
val n = true
when (n) {
 true -> {
println("WHEN true");
if (id!!.a != null) {
println("THEN");
return "fail"
}
}
 else -> {
println("WHEN ");
if (id!!.a == null) {
println("THEN");
return "fail"
}
}
}


    
val p = false
if (p) {
println("THEN");
r.extension()
} else {
println("ELSE");
r!!.extension()
}

    
val z = false
if (z) {
println("THEN");
Result<Int>(null).extension()
} else {
println("ELSE");
Result<Int>(null).extension()
}


    return "OK"
}