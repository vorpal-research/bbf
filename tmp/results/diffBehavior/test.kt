/ TARGET_BACKEND: JVM

// FULL_JDK

import java.net.*

fun String.decodeURI(encoding : String) : String? =
    try{
println("TRY");

        URLDecoder.decode(this, encoding)
}
    catch (e : Throwable){
println("CATCH e : Throwable");

        null
}

fun box() : String {
    return if("hhh".decodeURI("") == null) {
println("THEN");
"OK"
} else {
println("ELSE");
"fail"
}
}
