class A<T>(var value: T) {
    operator fun get(i: Int?) = value
operator fun set( i: Int,newValue: T):Unit = TODO()
}
val aDouble = A<Double>(1.0)
val s =
aDouble[0]--
