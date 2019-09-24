
open class Outer(
 fn: () -> Unit
) {
    companion object
class Inner : Outer({ this })
}
