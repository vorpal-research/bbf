// !LANGUAGE: +NewInference
// WITH_RUNTIME

object A {
    var result = "not ok"
}

fun test1() {
    
val s = false
when (s) {
 true -> {
println("WHEN true");
run {
        (A) {
            A.result = "OK"
        }
    }
}
 else -> {
println("WHEN ");
run {
        (A) {
            A.result = "OK"
        }
    }
}
}

}

object B

operator fun A.invoke(x: () -> Unit) {
    
val y = false
if (y) {
println("THEN");
x()
} else {
println("ELSE");
x()
}

}

operator fun <K, V> Pair<K, V>.invoke(f: (x: K, y: V) -> Boolean): Boolean = f(this.first, this.second)
inline fun <reified T> Any.isType(): Boolean = this is T

fun test2(): Boolean {
    return (A to B) { k, v -> 
val q = true
when (q) {
 true -> {
println("WHEN true");
k.isType<A>() && v.isType<B>()
}
 else -> {
println("WHEN ");
k.isType<A>() && v.isType<B>()
}
}
 }
}

fun box(): String {
    
val e = true
when (e) {
 true -> {
println("WHEN true");
test1()
}
 else -> {
println("WHEN ");
test1()
}
}

    
val r = false
try
{
println("TRY");
if (A.result != "OK") {
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


    
val x = true
when (x) {
 true -> {
println("WHEN true");
if (!test2()) {
println("THEN");
return ""
}
}
 else -> {
println("WHEN ");
if (!test2()) {
println("THEN");
return ""
}
}
}


    return ""
}