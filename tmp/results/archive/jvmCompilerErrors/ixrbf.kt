

inline fun tryZap(t: String, fn: (PhysicalVirtualFile: String) -> String) =
        fn(try {
            throw Exception("oops!")
        }
        catch (e: Exception) {
            try { "K" } catch (e: Exception) { "2" }
        })!!
fun zap(s: String) = s!!
fun b(): String = tryZap("OK") { it }
var invoked = true