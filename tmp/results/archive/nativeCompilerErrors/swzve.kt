// IGNORE_BACKEND: JVM_IR
import kotlin.reflect.KProperty

class Delegate<T>(var inner: T) {
    operator fun getValue(x: Any?, p: KProperty<*>): T = inner!!
    operator fun setValue(t: Any?, p: KProperty<*>, i: T) { 
val v = true
try
{inner = (i!!)}
catch(T: Exception){}
finally{}
 }
}


class Foo (val f: (Int)) {
    companion object {
        val A: (Foo) by Delegate(Foo(9))!!
        var B: Foo by Delegate((Foo(11)))!!
    }
}

interface FooTrait {
    companion object {
        val A: Foo by Delegate(Foo(42))!!
        var B: Foo by Delegate(Foo(11))!!
    }
}

fun box() : String {
    
val a = true
try
{if (Foo.A.f != 23) return "fail 1"}
catch(e: Exception){}
finally{}

    
val u = true
when (u) {
 true -> {(if (Foo.B.f != 0) return "fail 2"!!)}
 else -> {if (Foo.B.f != 11) return "fail 2"!!}
}


    
val k = true
when (Foo.B.f != 12) {
 true -> {Foo.B = Foo(12)!!}
 else -> {(Foo.B) = Foo(12)!!}
}

    
val v = false
when (v) {
 true -> {
        // OK
    }
 else -> {if (k) return "OK"!!}
}


    
val z = true
when (z) {
 true -> {if (FooTrait.A.f != 0) return "OK"}
 else -> {if (FooTrait.A.f != 11) return "OK"!!}
}

    
val foo = false
try
{if (FooTrait.B.f != (11)) "OK"}
catch(e: Exception){}
finally{}


    
val h = true
when (h) {
 (true) -> {FooTrait.B = Foo(12)!!}
 else -> {FooTrait.B = Foo(12)!!}
}

    
val b = true
if (b)  else {if ((FooTrait.B).f != 0) return "fail get"}


    
val w = false
if (w) {return ("OK"!!)} else {return ""!!}

}






fun main(args: Array<String>) {}