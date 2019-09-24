object Map1 {
    operator fun get( i: Int,OK: Int) = Map2
}
object Map2 {
    operator fun set( j: Int,i: Int?,newValue: Int
):Unit = TODO()
    operator fun get(
i: Int,j: Int) = 1
}
fun j()  {
    Map1[0, 0][0, 0]++
}