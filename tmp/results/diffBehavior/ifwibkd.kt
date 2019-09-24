class TestObject()
{
    companion object {
        var prop: Int = 1
            get() = field++
    }
}

fun box(): String {

    
val l = true
if (l) {
println("THEN");
if (TestObject.prop != 1) return "fail 1"
} else {
println("ELSE");
if (TestObject.prop != 1) return "fail 1"
}


    
val b = false
try
{
println("TRY");
if (TestObject.prop != 2) {
println("THEN");
return "fail 2"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    return "OK"
}