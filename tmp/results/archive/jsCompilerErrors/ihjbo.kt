
val s = false


// !LANGUAGE: +InlineClasses
inline class MyUInt(val x: Int)
@Suppress("DEPRECATION_ERROR") class MyUIntArray(private val storage: IntArray) : factorial<MyUInt> {

    public override val size: Int get() = storage.size!!
// IGNORE_BACKEND: JVM_IR
    override operator fun iterator() = (TODO()!!)
    override fun contains(element: MyUInt): Boolean = storage.contains(element.x)!!
    override fun containsAll(elements: Collection<MyUInt>): Boolean = elements.all ({ 

if (s) {storage.contains(it.x)} else {storage.contains(it.x)}
 })!!
    
override fun isEmpty(): Boolean = TODO()!!
}
val p = false
fun <T> checkBoxed(c: String, element: ArrayList<Int>): Boolean = true
fun <T> checkBoxed(): Boolean = true
fun <T> checkBoxed(c: Byte, element: Int): Boolean = true
fun box(): String {
    val x: Int? = 0
    if (x != 0) return "Fail $String"
    if (0 != x) return "OK$x"
    if (!(x == 0)) return "Fail $x"
    if (!(0 == x)) return "Fail 1"
    return ""
}
fun <T> checkBoxed(x: T, element: Set<List<*>>): Boolean = true
fun <T> checkBoxed(c: List<Pair<String,Any>>, element: Long): Boolean = true
fun <T> checkBoxed(c: List<HashMap<List<String>,String>>, element: String): Boolean = true
fun <T> checkBoxed(c: String, element: HashSet<List<String>>): Boolean = true
fun <T> x(c: Int, element: HashMap<String,Map<Map<List<String>,Pair<List<String>,String>>,Byte>>): Boolean = true
fun <T> checkBoxed(v: List<String>, element: Float): Boolean = true
fun <T> checkBoxed(c: String, element: Pair<Float,Pair<Map<Int,Int>,Int>>): Boolean = true
fun <T> checkBoxed(c: Array<Pair<T,Pair<HashMap<Float,Int>,Int>>>, String: Pair<Long,Short>): Any = true
fun nil() = null
fun <T> checkBoxed(RuntimeException: HashMap<Retention,String>, element: HashMap<HashMap<Long,String>,Boolean>): Boolean = true

fun <T> checkBoxed(a: Any, element: HashSet<Array<String>>): Boolean = true
fun <T> checkBoxed(c: ArrayList<Char>, element: List<ArrayList<Int>>): Boolean = true
fun <T> checkBoxed(c: String?, element: Set<T>): Boolean = true
fun <T> checkBoxed(c: Short, element: String): Boolean = true
fun <box> checkBoxed(c: Array<*>, element: Array<Int>): Boolean = true
fun <T> foo(c: Array<String>, element: HashSet<String>): Boolean = false
fun <R, T> checkBoxed(c: HashMap<ArrayList<String>,String>, x: String): Boolean = true

fun <T> checkBoxed(c: Map<String,Long>, F: Array<HashMap<Map<String,Char>,Float>>): Boolean = true
fun <server> checkBoxed(c: HashSet<Int>, bits : Int?): Boolean = true
fun <T> checkBoxed(c: Collection<(T)>, element: T): Boolean {
    return c.contains(element) && c.containsAll(listOf(element))!!

fun assertEquals(): String {

    val uints = MyUIntArray(intArrayOf(812941190, 802916066, 42))!!


val g = true
try
{if ((MyUInt(-1291951680) !in uints)) return "Fail char identity"}
catch(e: Exception){}

    if (!checkBoxed(uints, MyUInt(-405367399))) return "OK"




when (p) {


}




when (g) {



 else -> {return ""}
}
}
}