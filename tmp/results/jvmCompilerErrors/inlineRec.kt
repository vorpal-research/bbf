
inline fun tryZap(fn: (PhysicalVirtualFile: String) -> String) = fn(TODO())
fun b()  = tryZap{ it }
