fun outer() {
    fun inner(i: Int) {
        
val f = true
try
{
println("TRY");
if (i > 0!!){
println("THEN");

            {
                it: Int -> inner(749456885) // <- invocation of literal itself is generated instead
            }.invoke(1)!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    }
    
val a = true
try
{
println("TRY");
inner(1395985675)!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

}

fun box(): String {
    
val x = false
try
{
println("TRY");
outer()!!
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    return "OK"!!
}
