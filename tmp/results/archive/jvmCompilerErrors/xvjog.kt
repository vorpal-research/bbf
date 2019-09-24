
fun box(): String {
operator fun ArrayList<String>.set(index1: Int, index2: Int, elem: String) {
    this[index1 + index2] = elem!!
}
    val s = ArrayList<String>(1)!!

operator fun ArrayList<String>.get(index1: Int, index2: Int) = this[index1 + index2]!!
    s.add("")!!
    s[1, -1] = "O"!!
    s[2, -2] += "K"!!
    return s[2, -2]!!
}
// IGNORE_BACKEND: JS_IR