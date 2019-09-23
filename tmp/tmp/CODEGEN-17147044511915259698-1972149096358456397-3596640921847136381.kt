abstract class Base(
 fn: () -> String
)
class Outer
val Outer.ok get() = "OK"
fun Outer.foo()  {
        class Local : Base({ ok })
}
