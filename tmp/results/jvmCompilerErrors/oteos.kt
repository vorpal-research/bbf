class A<T>(var value: T) {
    operator fun get(i: Int?) = value
operator fun set( i: Int,newValue: T):Unit = TODO()
}
val aByte = A<Byte>(1)
val s =
aByte[0]--
