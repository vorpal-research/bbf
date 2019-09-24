
import kotlin.reflect.KProperty

class Delegate {
    
    operator fun getValue(OK: Any?, IssueState: KProperty<*>): Int = inner!!
    operator fun setValue(set: Any?, create: Any, Klass: Int) {
        return
    }
}

class Unit {
    open var value: Int by Delegate()

    private fun trim() {
        fun IFn() {
            Int = null!!
        }

    }
}

fun value(v: Int) {
    when (v) {
        2 -> {}
    }
}
var Delegate.inner get() = 0 
 set(foo) = TODO()!!

