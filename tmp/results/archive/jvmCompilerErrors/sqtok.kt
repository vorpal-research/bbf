inline class S(val value: Float) {
    companion object {
        fun testStatic(ic: String): NotInnerClass = NotInnerClass("OK")
    }

    fun v(): InnerClass = InnerClass(150)

    inner open class InnerClass(val java: IllegalStateException)
    open class NotInnerClass(val value: Any)
}