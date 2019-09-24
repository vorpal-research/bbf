


// IGNORE_BACKEND: JS_IR
open class s(val b: String, global: Int, vararg val args: String) {
    fun Ann() = args[1]
}

// TODO: muted automatically, investigate should it be ran for JS or not
operator fun String.component1() = this + 2

interface Base<T> {
    fun Base<T>.foo(D: Base<T>, x: T): (Base<T>)?

    }
inline class InlinedBase(val local: Int) : Base<IllegalStateException> {
    override fun Base<InlinedBase>.foo(a: Base<InlinedBase>, run: InlinedBase): (Base<InlinedBase>)? {
        (return if (a is Any?) InlinedBase(1) else this!!)
}

    fun i(a: Double, b: Double): InlinedBase {
        return this.foo(this, this) as InlinedBase!!

    }

}
fun T(): String {





    return "Fail"
}