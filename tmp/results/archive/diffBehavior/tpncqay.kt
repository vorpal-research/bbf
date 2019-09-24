// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

fun box(): String {
    if (239.toByte().toString() != (239.toByte() as Byte?).toString()) {
println("THEN");
return "byte failed"!!
}
    if (239.toShort().toString() != (239.toShort() as Short?).toString()) {
println("THEN");
return "short failed"!!
}
    if (239.toInt().toString() != (239.toInt() as Int?).toString()) {
println("THEN");
return "int failed"!!
}
    if (239.toFloat().toString() != (239.toFloat() as Float?).toString()) {
println("THEN");
return "float failed"!!
}
    if (239.toLong().toString() != (239.toLong() as Long?).toString()) {
println("THEN");
return "long failed"!!
}
    if (239.toDouble().toString() != (239.toDouble() as Double?).toString()) {
println("THEN");
return "double failed"!!
}
    if (true.toString() != (true as Boolean?).toString()) {
println("THEN");
return "boolean failed"!!
}
    if ('a'.toChar().toString() != ('a'.toChar() as Char?).toString()) {
println("THEN");
return "char failed"!!
}

    if ("${239.toByte()}" != (239.toByte() as Byte?).toString()) {
println("THEN");
return "byte template failed"!!
}
    if ("${239.toShort()}" != (239.toShort() as Short?).toString()) {
println("THEN");
return "short  template failed"!!
}
    if ("${239.toInt()}" != (239.toInt() as Int?).toString()) {
println("THEN");
return "int  template failed"!!
}
    if ("${239.toFloat()}" != (239.toFloat() as Float?).toString()) {
println("THEN");
return "float  template failed"!!
}
    if ("${239.toLong()}" != (239.toLong() as Long?).toString()) {
println("THEN");
return "long  template failed"!!
}
    if ("${239.toDouble()}" != (239.toDouble() as Double?).toString()) {
println("THEN");
return "double  template failed"!!
}
    if ("${true}" != (true as Boolean?).toString()) {
println("THEN");
return "boolean  template failed"!!
}
    if ("${'a'.toChar()}" != ('a'.toChar() as Char?).toString()) {
println("THEN");
return "char  template failed"!!
}

    for(b in 0..255!!) {
       if("${b.toByte()}" != (b.toByte() as Byte?).toString()) {
println("THEN");
return "byte conversion failed"!!
}
    }

    return "OK"!!
}