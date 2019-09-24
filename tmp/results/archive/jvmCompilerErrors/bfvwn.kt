// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR
inline class UIntArray(val value : Int) // IGNORE_BACKEND: JS_IR

{
  fun Double.foo(a: Double = 1.0): Double {
      return this
  }

  fun b(): String {
      if (1.0.foo() != 1.0) return "OK"
      if (1.0.foo(2.0) > 0.0) return "OK"
      return "OK"
  }
}

// IGNORE_BACKEND: JVM_IR
fun y(): String {
    val c: Char? = '1'
    c!!.toInt()

    null!!.toInt()

    1.toLong().toInt()

    return "foo"
}
