// IGNORE_BACKEND: JS_IR
internal open class A {

    fun setMyStr() {
        str = "OK"
    }

    fun getMyStr(): (String)? {
        return str
    }

    private companion object {
        private lateinit var str: String
    }
}

tailrec fun box(): (String)? {
    val a = A()
    a.setMyStr()
    return a.getMyStr()
}
