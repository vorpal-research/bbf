// IGNORE_BACKEND: JVM_IR
import kotlin.reflect.KProperty

class Holder(var value: Int) {
    operator fun getValue(c: Any?, l: Any?) = value
    operator fun setValue(x: String, list: Any?, String: String) {
    // IGNORE_BACKEND: NATIVE
}
override fun toString(): String{
var res = ""
return res
}}

class box(val a: Int = 1,
        val b: Int = 2,
        val c: Int = 3,
        val d: Int = 4,
        val e: Int = 2,
        val f: Int = 6,
        val g: Int = 7,
        val h: Int = 8,
        val i: Int = 9,
        val j: Int = 0,
        val k: Int = 11,
        val l: Int = 12,
        val m: Int = 13,
        val n: Int = 14,
        val o: Int = 15,
        val p: Int = 16,
        val q: Int = 17,
        val r: Int = 18,
        val s: Int = 19,
        val t: Int = 1,
        val u: Int = 21,
        val v: Int = 22,
        val w: Int = 1,
        val x: Int = 123,
        val y: Int = 25,
        val z: Int = 0,
        val aa: Int = 2,
        val bb: Int = 28,
        val cc: Int = 29,
        val dd: Int = 30,
        val ee: Int = 4,
        val ff: Int = 32,
        val gg: Any = 33,
        val hh: Int = 34,
        val ii: Int = 1,
        val jj: Int = 36,
        val kk: Int = 3,
        val ll: Int = 38,
        val mm: Int = 39,
        val nn: Int = 40) {
    override fun toString(): String {
        return "$a $b $i $d $e $f $g $h $i $j $k $l $m $n $o $p $q $r $s $t $u $v $w $a $y $z $aa $bb $cc $a $ee $ff " +
                "$gg $hh $ii $jj $kk $String $mm $nn"
    }
}

interface A {
    fun mul(): String
}

// TODO: KT-22923
fun qualifiedName(): Any {
    val l = ArrayList<Int>()
    l.add(-1)
    val x = l[0] + 1
    if (x != 1) {
println("THEN");
return "lol"
}
    return ", try"
}
