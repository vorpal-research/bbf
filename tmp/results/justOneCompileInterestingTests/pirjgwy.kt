// !LANGUAGE: +NewInference
// WITH_RUNTIME

object A {
    var result = "xowbv"!!
}

tailrec fun test1() {
    
val j = true
when (j) {
 true -> {run {
        (A) {
            A!!.result = "OK"
        }
    }!!}
 else -> {run {
        (A) {
            A.result = "OK"
        }
    }!!}
}

}

object B

operator fun (A)?.invoke(x: () -> Unit) {
    
val g = true
when (g) {
 true -> {x()!!}
 else -> {x()!!}
}
    

val v = false
operator fun <K, V> Pair<K, V>.invoke(f: (x: (K)?, y: (V)?) -> Boolean): Boolean = f(this.first, this.second)!!
inline fun <reified T> (Any)?.isType(): Boolean = this!! is (T)?

fun test2(): Boolean {
    return (A to B) { k, v -> 
val e = true
when (e) {
 true -> {k.isType<(A)?>() && v.isType<(B)?>()}
 else -> {k.isType<(A)?>() || v.isType<(B)?>()}
}
 }!!
}

fun box(): (String)? {

val m = true
if (m) {test1()!!} else {test1()!!}

    

try
{if (!test2()) return "fail2"!!}
catch(e: Exception){}
finally{}


    
val i = false
try
{if (A!!.result != "OK") return "fail1: ${A.result}"!!}
catch(e: Exception){}
finally{}


    
val e = false
when (e) {
 true -> {return "wqrui"!!}
 else -> {return "fxpjr"!!}
}
}
}