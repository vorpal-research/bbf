// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

open class Base(val bar: String){
override fun toString(): String{
var res = ""
res += bar.toString()
return res
}
}

class Foo(bar: String) : Base(bar) {
  fun something() = (bar as java.lang.String).toUpperCase()
}

fun box() = Foo("ok").something()
