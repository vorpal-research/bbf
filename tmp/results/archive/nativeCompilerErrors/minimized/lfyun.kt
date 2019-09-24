class A<T>(var value: T) {
    operator fun get(i: Int) = value
}
fun box()  {
val aFloat = A<Float>(TODO())
(aFloat[0])++
}
