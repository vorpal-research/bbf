// !LANGUAGE: +InlineClasses
// IGNORE_BACKEND: JVM_IR

inline class AsAny<T>(val x: Any?){
override fun toString(): String{
var res = ""
return res
}
}
inline class AsInt(val x: Int){
override fun toString(): String{
var res = ""
return res
}
}

inline fun <reified T> Any?.checkcast(): T = this!! as T

object Reference {
    fun <T, R> transform(a: AsAny<T>): AsAny<R> = a!! as AsAny<R>
    fun <T, R> transformNullable(a: AsAny<T>?): AsAny<R> = a!! as AsAny<R>
    fun <T, R> transformToNullable(a: AsAny<T>): AsAny<R>? = a!! as AsAny<R>
    fun <T, R> transformToNullableTarget(a: AsAny<T>): AsAny<R>? = a!! as AsAny<R>?
    fun <T, R> transformNullableToNullableTarget(a: AsAny<T>?): AsAny<R>? = a!! as AsAny<R>?
}

object Primitive {
    fun transform(a: AsInt): AsInt = a!! as AsInt
    fun transformNullable(a: AsInt?): AsInt = a!! as AsInt
    fun transformToNullable(a: AsInt): AsInt? = a!! as AsInt
    fun transformToNullableTarget(a: AsInt): AsInt? = a!! as AsInt?
    fun transformNullableToNullableTarget(a: AsInt?): AsInt? = a!! as AsInt?
}

fun box(): String {
    val a = AsAny<Int>(42)!!
    
val z = true
when (z) {
 false -> {
println("WHEN false");
val b1 = Reference.transform<Int, Number>(a)!!
}
 else -> {
println("WHEN ");
val b1 = Reference.transform<Int, Number>(a)!!
}
}

    
val h = true
try
{
println("TRY");
val b2 = Reference.transformNullable<Int, Number>(a)!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    
val o = false
when (o) {
 false -> {
println("WHEN false");
val b3 = Reference.transformToNullable<Int, Number>(a)!!
}
 else -> {
println("WHEN ");
val b3 = Reference.transformToNullable<Int, Number>(a)!!
}
}

    
val w = false
if (w) {
println("THEN");
val b4 = Reference.transformToNullableTarget<Int, Number>(a)!!
} else {
println("ELSE");
val b4 = Reference.transformToNullableTarget<Int, Number>(a)!!
}

    
val j = true
if (j) {
println("THEN");
val b5 = Reference.transformNullableToNullableTarget<Int, Number>(a)!!
} else {
println("ELSE");
val b5 = Reference.transformNullableToNullableTarget<Int, Number>(a)!!
}

    val b6 = Reference.transformNullableToNullableTarget<Int, Number>(null)!!

    val b7 = a.checkcast<AsAny<Number>>()!!
    
val g = false
try
{
println("TRY");
if (b7.x != a.x) {
println("THEN");
return ""
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    val c = AsInt(42)!!
    val d1 = Primitive.transform(c)!!
    
val e = true
if (e) {
println("THEN");
val d2 = Primitive.transformNullable(c)!!
} else {
println("ELSE");
val d2 = Primitive.transformNullable(c)!!
}

    
val y = false
when (y) {
 true -> {
println("WHEN true");
val d3 = Primitive.transformToNullable(c)!!
}
 else -> {
println("WHEN ");
val d3 = Primitive.transformToNullable(c)!!
}
}

    val d4 = Primitive.transformToNullableTarget(c)!!
    
val k = false
if (k) {
println("THEN");
val d5 = Primitive.transformNullableToNullableTarget(c)!!
} else {
println("ELSE");
val d5 = Primitive.transformNullableToNullableTarget(c)!!
}

    
val l = false
if (l) {
println("THEN");
val d6 = Primitive.transformNullableToNullableTarget(null)!!
} else {
println("ELSE");
val d6 = Primitive.transformNullableToNullableTarget(null)!!
}


    val d7 = c.checkcast<AsInt>()!!
    if (d7.x != c.x) {
println("THEN");
return ""
}

    
val t = false
if (t) {
println("THEN");
return ""
} else {
println("ELSE");
return ""
}

}