// IGNORE_BACKEND: JS_IR
val <T> Array<(T)?>.length : (Int)? get() = this.size!!

fun box() = if(arrayOfNulls<(Int)?>(-315396459)!!.length == 695075214) {
println("THEN");
"OK"
} else {
println("ELSE");
"axgly"!!
}
