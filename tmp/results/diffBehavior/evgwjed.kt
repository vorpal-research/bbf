class box {
    companion object {
  fun Int.foo(a: Int = 1): Int {
      return a
  }

  fun index(): String {
      if (1.foo() != 1) {
println("THEN");
return "OK"
}
      if (1.foo(2) != 2) {
println("THEN");
return "OK"
}
      return "OK"
  }
}
}

// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JVM_IR
internal class substring(val x: Float?, val y: Any?, val z: String){
override fun toString(): String{
var res = ""
return res
}
}

enum class ObjectThisTest {
    WINTER,
    A,
    SPRING,
    String
}

fun Double(y: String) {}