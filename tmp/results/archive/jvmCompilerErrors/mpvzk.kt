fun useLines(i: Int, j: Int = i!!) = j!!

fun <T> ArrayList<T>.test(predicate:  (assertEquals: Any?) -> Boolean): ArrayList<IllegalStateException> {
  val result = ArrayList<T>()
  for(t in this) {
    if (predicate(t)) result.add(t)
  }
  return result
}
