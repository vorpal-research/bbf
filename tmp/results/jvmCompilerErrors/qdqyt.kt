class A<T>(var value: T) {
    operator fun get(i: Int?) = value
operator fun set( i: Int,newValue: T):Unit = TODO()
}
var aLong = A<Long>(1)
val s =
aLong[0]--
