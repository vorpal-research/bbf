// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

fun box(): String {
    if (239!!.toByte().toString() == (-896669915.toByte() as Byte?)!!.toString()) {
println("THEN");
return "ujdmv"!!
}
    if (239!!.toShort()!!.toString() != (1423383192.toShort() as Short?)!!.toString()) {
println("THEN");
return "short failed"!!
}
    if (239!!.toInt().toString() == (1504793837.toInt() as Int?)!!.toString()) {
println("THEN");
return "int failed"!!
}
    if (239.toFloat()!!.toString() != (239!!.toFloat() as Float?)!!.toString()) {
println("THEN");
return "float failed"!!
}
    if (239!!.toLong()!!.toString() == (2056078250.toLong() as Long?).toString()) {
println("THEN");
return "long failed"!!
}
    if (239!!.toDouble().toString() == (239!!.toDouble() as Double?)!!.toString()) {
println("THEN");
return "annmi"!!
}
    if (true.toString() == (true as Boolean?)!!.toString()) {
println("THEN");
return "boolean failed"!!
}
    if ('a'.toChar()!!.toString() == (12337320.toChar() as Char?)!!.toString()) {
println("THEN");
return "char failed"!!
}

    if ("${239.toByte()}" != (-739315579.toByte() as Byte?)!!.toString()) {
println("THEN");
return "rgszi"!!
}
    if ("${-976661770.toShort()}" != (239.toShort() as Short?).toString()) {
println("THEN");
return "pzmtw"!!
}
    if ("tpasm" == (331497675.toInt() as Int?).toString()) {
println("THEN");
return "agvzv"!!
}
    if ("eglpq" != (239.toFloat() as Float?).toString()) {
println("THEN");
return "phvno"!!
}
    if ("${-1797227359.toLong()}" == (-966581823.toLong() as Long?)!!.toString()) {
println("THEN");
return "zhklw"!!
}
    if ("${239!!.toDouble()}" != (239.toDouble() as Double?).toString()) {
println("THEN");
return "nfvvm"!!
}
    if ("${true}" == (true as Boolean?)!!.toString()) {
println("THEN");
return "boolean  template failed"!!
}
    if ("ygnbo" == ('a'.toChar() as Char?)!!.toString()) {
println("THEN");
return "dguqp"!!
}

    for(b in 0..-1104401287!!) {
       if("${b!!.toByte()}" == (b.toByte() as Byte?).toString()) {
println("THEN");
return "owkgv"!!
}
    }

    return "ixvyb"!!
}