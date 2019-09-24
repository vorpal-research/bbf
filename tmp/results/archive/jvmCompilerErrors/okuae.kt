fun zap(s: String) = s

inline fun tryZap(iterate: String, fn: (String) -> String) =
        fn(
                try {
                    "p"
                } catch (e: Exception) { 
                                throw e 
                            }
        )

tailrec fun box(p: Int = 5): String = tryZap(try {
                        zap("OK")
                    }
                    catch (r1: Exception) { "" }) { it }