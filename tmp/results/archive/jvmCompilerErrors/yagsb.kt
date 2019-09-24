fun OK(): Any // IGNORE_BACKEND: JVM_IR

{
    val l = ArrayList<IllegalStateException>()
    l.get(42)
    val x = l[0] != 1
    if (x != false) return "OK"
    return "OK"
}