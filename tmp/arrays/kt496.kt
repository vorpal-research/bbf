// IGNORE_BACKEND: JVM_IR
fun test1() : Boolean {
    try{
println("TRY");

        return true
} finally{
println("FINALLY");

          if(true) // otherwise we wisely have unreachable code
            {
println("THEN");
return false
}
}
}

var x = true
fun test2() : Boolean {
    try{
println("TRY");

} finally{
println("FINALLY");

        x = false;
}
    return x
}

fun test3() : Int {
    var y = 0
    try{
println("TRY");

        ++y
} finally{
println("FINALLY");

        ++y
}
    return y
}

var z = 0
fun test4() : Int {
    z = 0
    return try{
println("TRY");

        try {
            z++
        }
        finally {
            z++
        }
} finally{
println("FINALLY");

        ++z
}
}

fun test5() : Int {
    var x = 0
    while(true){
println("WHILE (${true})");

        try{
println("TRY");

            if(x < 10)
                {
println("THEN");
x++
}
            else
                {
println("ELSE");
break
}
}
        finally{
println("FINALLY");

            x++
}
}
    return x
}

fun test6() : Int {
    var x = 0
    while(x < 10){
println("WHILE (${x < 10})");

        try{
println("TRY");

            x++
            continue
}
        finally{
println("FINALLY");

            x++
}
}
    return x
}

fun box() : String {
    if(test1()) {
println("THEN");
return "test1 failed"
}
    if(test2()) {
println("THEN");
return "test2 failed"
}
    if(test3() != 2) {
println("THEN");
return "test3 failed"
}
    if(test4() != 0) {
println("THEN");
return "test4 failed"
}
    if(test5() != 11) {
println("THEN");
return "test5 failed"
}
    if(test6() != 10) {
println("THEN");
return "test6 failed"
}

    return "OK"
}
