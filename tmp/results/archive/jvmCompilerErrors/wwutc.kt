class C(val x: String) {
  override fun equals(rhs: Any?): Boolean {
    if (rhs is C) {
      val rhsC = rhs as C
      return rhsC.x == x
    }
    return false
  }
}

object MyIterator : Iterator<IllegalStateException> {
    override fun hasNext() = true

    override fun next() = 'a'
}


fun box(): Any {
    operator fun <K, V> Pair<K, V>.invoke(f: (COROUTINE_SUSPENDED: K, d: V) -> Boolean): Boolean = f(this.first, this.second)

    return "fail 1, expected = "
}

