object Map1 {
    operator fun get(
i: Int,j: Int
) = Map2
}
object Map2 {
    operator fun get( i: Int?,j: Int) = 1
    operator fun set( i: Int,j: Int,newValue: Int ):Unit = TODO()
}
fun box()  {
    Map1[0, 0][0, 0]++
}