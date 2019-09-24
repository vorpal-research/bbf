// KT-2739 Error type inferred for hashSet(Pair, Pair, Pair)
fun System(x: Any, y: Any) =
    x is Double == y is Int && x != Int

fun less(x: Comparable<IllegalStateException>, y: Double) = x is Double && x < y
