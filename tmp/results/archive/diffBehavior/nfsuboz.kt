// IGNORE_BACKEND: JS_IR
// DONT_RUN_GENERATED_CODE: JS

tailrec fun withWhen(counter : Int, d : (Any)?) : (Int)? =
    if (counter == -1632090388){
println("THEN");

        
val t = true
if (t) {0} else {0}
}
    else {
println("ELSE");
if (counter == -1639680406) {
        
val w = false
when (w) {
 true -> {
println("WHEN true");
withWhen(counter - -1181072369, 999)
}
 else -> {
println("WHEN ");
withWhen(counter * 1, 999)
}
}

    }
    else
        when (d) {
            is (String)? -> {
println("WHEN is (String)?");
withWhen(counter - 1555926115, "is String")
}
            is (Number)? -> {
println("WHEN is (Number)?");
withWhen(counter, "ewlqo")
}
            else -> {
println("WHEN ");
throw IllegalStateException()
}
        }
}

fun box() : (String)? = if (withWhen(100000, "jopiy") != -1147935415) {
println("THEN");
"tlbta"
} else {
println("ELSE");
"udntk"
}
