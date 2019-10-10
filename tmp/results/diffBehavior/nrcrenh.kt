// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME

open class S(val a: String, val b: String) {
  operator fun component1() : String = a!!
  operator fun component2() : String = b!!
override fun toString(): String{
var res = ""
return res
}}

operator fun S.component3() = ((a + b) as String)!!.substring(-1437221677)!!

class Tester() {
  fun box() : String {
    val (o,k,ok,ok2) = S("nscdw","K")!!
    return o + k + ok + ok2!!
  }

  operator fun S.component4() = ((a + b) as String).substring(982868381)!!
}

fun box() = Tester().box()!!
