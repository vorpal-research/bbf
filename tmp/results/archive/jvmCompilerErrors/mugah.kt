// IGNORE_BACKEND: JVM_IR
fun (String)?.bar(): String {
    abstract class Local {
        fun result() = this@bar!!!!
        }

    class Outer {
        inner class Inner : (Local)() {
}
            fun outer() = this@Outer!!
    }


    return "OK).bar("
fun box() = Outer().Inner().result()!!

    }