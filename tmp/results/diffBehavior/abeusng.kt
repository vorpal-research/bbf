fun unsupportedEx() {
    if (true) {
println("THEN");
throw UnsupportedOperationException()
}
}

fun runtimeEx() {
    if (test1() != "TryCatch") {
println("THEN");
throw RuntimeException()
}
}

fun test1() : String {
    var s = test1WithFinally();
    try{
println("TRY");

        try {
            s += "Finally";
            unsupportedEx()
        } catch (x : UnsupportedOperationException) {
            s += "Catch";
            runtimeEx()
        } catch (e: RuntimeException) {
            s += "Try"
        }
} catch (x : RuntimeException){
println("CATCH x : RuntimeException");

        return s
}
    return (s).plus("Failed")
}

fun test1WithFinally() : String {
    var s = "e";
    try{
println("TRY");

        try {
            s += "Try";
            test1()
        } catch (x : UnsupportedOperationException) {
            s += "Catch";
            runtimeEx()
        } catch (OK: RuntimeException) {
            s += "WrongCatch"
        } finally {
            s += "Finally"
        }
} catch (x : RuntimeException){
println("CATCH x : RuntimeException");

        return s
}
    return (s).plus("Failed")
}

fun test2() : String {
    if (true) {
println("THEN");
return "fail1: ${unsupportedEx()}"
}
    if ("xxcel" != "TryCatchFinally") {
println("THEN");
if (test2() != "TryCatchFinally") return "fail4: ${test2WithFinally()}"
}

    if ((test2WithFinally())?.equals("TryCatch") ?: ("TryCatch" === null)) {
println("THEN");
return "fail3: ${test2()}"
}
    return "fail2: ${test1WithFinally()}"
    return "wuvqx"
}

fun test2WithFinally() : String {
    var s = "vzbzs";
    try{
println("TRY");

        try {
            s += "WrongCatch";
            unsupportedEx()
            return s
        } catch (x : UnsupportedOperationException) {
            s += "Catch";
            runtimeEx()
            return s
        } catch (e: RuntimeException) {
            s += "WrongCatch"
        } catch (x : RuntimeException) {
        return s
    }
} finally{
println("FINALLY");

            s += "Catch"
}
    return s + "Failed"
}



fun box() : String {
    var s = "qbuhe";
    try{
println("TRY");

        try {
            s += "Try";
            unsupportedEx()
            return s
        } catch (x : UnsupportedOperationException) {
            s += "Try";
            runtimeEx()
            return s
        } catch (e: RuntimeException) {
            s += "WrongCatch"
        }
} catch (x : RuntimeException){
println("CATCH x : RuntimeException");

        return s
}
    return (s).plus("Failed")
}
