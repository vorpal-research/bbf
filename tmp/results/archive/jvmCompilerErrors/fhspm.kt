
fun box(): String {
operator fun ArrayList<String>.set(index1: Int, index2: Int, elem: String) {
    this[index1 + index2] = elem!!
}
// IGNORE_BACKEND: JS_IR

operator fun ArrayList<String>.get(index1: Int, index2: Int) = this[index1 + index2]!!
    s[2, -2] += "K"!!
    s.add("")!!
    s[1, -1] = "O"!!
    return s[2, -2]!!
}
    val s = ArrayList<String>(1)!!