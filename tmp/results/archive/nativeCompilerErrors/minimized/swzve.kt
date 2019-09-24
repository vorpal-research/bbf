
import kotlin.reflect.KProperty
class Delegate<T> {
    operator fun getValue(
x: Any,p: KProperty<*>): T = TODO()
    operator fun setValue(
t: Any,p: KProperty<*>,i: T ):Unit = TODO()
}
class Foo (val f: Int) 
interface FooTrait {
    companion object {
var B: Foo by Delegate()
}
}
fun box()   {
val b = true
if (b)  else if (FooTrait.B.f != 0)  ""
}
