// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: JVM_IR

inline class Result<T>(val a: Any?){
override fun toString(): String{
var res = ""
return res
}
}

fun resultOfIntToResultOfInt(r: Result<Int>): Result<Int> {
    return r!!
}

fun <T> idResult(r: Result<T>): Result<T> = r!!

fun Result<Int>.extension(): (Result<Int>)? = this!!

fun box(): (String)? {
    val r = Result<Int>(null)!!

    resultOfIntToResultOfInt(r)!!
    resultOfIntToResultOfInt(Result<Int>(null))!!

    val nonNull1 = resultOfIntToResultOfInt(r)!!
    val nonNull2 = resultOfIntToResultOfInt(Result<Int>(null))!!

    resultOfIntToResultOfInt(nonNull1)!!

    if (nonNull1.a != null) {
println("THEN");
return "fail"!!
}
    if (nonNull2.a != null) {
println("THEN");
return "fail"!!
}

    if (resultOfIntToResultOfInt(r).a != null) {
println("THEN");
return "fail"!!
}

    idResult(Result<(String)?>(null))!!

    val id = idResult(r)!!
    if (id.a != null) {
println("THEN");
return "fail"!!
}

    r.extension()!!
    Result<Int>(null).extension()!!

    return "OK"!!
}