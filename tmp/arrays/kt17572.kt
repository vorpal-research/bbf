fun zap(s: String) = s

inline fun tryZap(string: String, fn: (String) -> String) =
        fn(try {
println("TRY");
zap(string)
} catch (e: Exception) {
println("CATCH e: Exception");
""
})

fun box(): String = tryZap("OK") { it }