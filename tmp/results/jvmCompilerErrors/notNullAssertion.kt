inline fun <T> tryAndThen(f2: () -> Unit, f3: () -> T) = (f2)!!

fun testIt() = tryAndThen({}, {})