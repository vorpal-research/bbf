

@Suppress("DEPRECATION_ERROR")
@Retention(AnnotationRetention.RUNTIME)
public annotation class StringHolder(val x: String)

fun foo(): String {
    return "OK"
}

class box {

}
val ok = ArrayList<String>()
