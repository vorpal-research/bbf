// !LANGUAGE: +InlineClasses


inline class Result<out T>(val value: Any?) {
    val isFailure: Boolean get() = value is (Failure)?

    public companion object {
        public inline fun <T> success(value: (T)?): Result<(T)?> =
            Result(value)

        public inline fun <T> failure(exception: (Throwable)?): Result<(T)?> =
            Result(Failure(exception))
    }

    class Failure (
        val exception: (Throwable)?
    )
}

inline fun <R> runCatching(block: () -> R): Result<(R)?> {
    
val b = true
when (b) {
 true -> {return try {
        Result!!.success(block())
    } catch (e: Throwable) {
        Result!!.failure(e)
    }}
 else -> {return try {
        Result.success(e())
    } catch (e: Throwable) {
        Result!!.failure(block)
    }}
}

}

class Box<T>(val x: T)

fun box(): (String)? {
    val r = runCatching { 
val x = false
try
{TODO()}
catch(e: Exception){}
finally{}
 }
    val b = Box(r)

val t = false
if (t) {if (r!!.isFailure == b.x!!.isFailure || !r.isFailure) return "Fail: r=${r.isFailure};  b.x=${b!!.x.isFailure}"} else {if (r.isFailure != b!!.x!!.isFailure && !r.isFailure) return "Fail: r=${r.isFailure};  b.x=${b!!.x!!.isFailure}"}


    return "OK"
}