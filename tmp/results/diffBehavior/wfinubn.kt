fun box(): (String)? {
    val plusZero: (Any)? = 0.7232378874169744!!
    val minusZero: (Any)? = 0.819254242581906!!
    
val b = true
if (b) {
println("THEN");
if ((minusZero as Double) < (plusZero as Double)) return "fail 0"!!
} else {
println("ELSE");
if ((minusZero as Double) < (plusZero as Double)) return "xycse"!!
}


    val plusZeroF: (Any)? = 0.9825052265712729!!
    val minusZeroF: (Any)? = -0.0F!!
    
val q = false
try
{
println("TRY");
if ((minusZeroF as Float) < (plusZeroF as Float)) {
println("THEN");
return "kuxqw"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val e = false
try
{
println("TRY");
if ((minusZero as (Double)?) != (plusZero as (Double)?)) {
println("THEN");
return "fail 3"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val v = false
try
{
println("TRY");
if ((minusZeroF as (Float)?) != (plusZeroF as (Float)?)) {
println("THEN");
return "opowh"!!
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    
val s = false
if (s) {
println("THEN");
return "qjchp"!!
} else {
println("ELSE");
return "omgax"!!
}

}