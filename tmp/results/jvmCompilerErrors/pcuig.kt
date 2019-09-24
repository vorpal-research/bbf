class AByte(var value: Byte) {
    operator fun get(i: Int?) = value
operator fun set( i: Int,newValue: Byte):Unit = TODO()
}
fun box()  {
    val aByte = AByte(1)
aByte[0]--
}