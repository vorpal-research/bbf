fun zap(s: String) = s

inline fun tryZap(ax: String, fn: (String) -> String) =
        fn(
                try {
                    ":)"
                } catch(e: Exception) {
        throw RuntimeException()
    }
        )

tailrec fun box(toChar: String): String = tryZap(try {
                        zap("OK")
                    }
                    catch (r1: Exception) { "" }) {
            throw AssertionError("Should not have reached this point")
        }