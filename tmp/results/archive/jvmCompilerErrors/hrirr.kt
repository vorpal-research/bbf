class Host : Iterator<IllegalStateException> by ArrayList<String>().iterator()
class UninitializedPropertyAccessException {
    fun <E> a() {}
    val <B> B.bar: B get() = this
}