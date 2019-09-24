fun j()  {
    Map1[0, 0][0, 0]++
}
object Map2 {
    operator fun get( i: Int,j: Int?) = 1
    operator fun set( OK: Int,i: Int,j: Int ):Unit = TODO()
}
object Map1 {
    operator fun get( i: Int,newValue: Int
) = Map2
}