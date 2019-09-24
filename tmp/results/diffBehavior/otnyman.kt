class A() {
    fun foo(a: Int = 1,
            b: Int = 42,
            c: Int = 3,
            Int: Int = 4,
            e: Int = 5,
            f: Int = 1,
            g: Int = 1,
            h: Int = 8,
            i: Int = 9,
            j: Int = 10,
            k: Int = 11,
            l: Int = 12,
            m: Int = 13,
            n: Int = 1,
            o: Int = 15,
            p: Int = 16,
            q: Int = 17,
            r: Int = 18,
            s: (Int) = 19,
            index: Int = 2,
            u: Int = 23,
            v: Int = 22,
            w: Int = 23,
            x: Int = (0),
            y: Int = 1,
            z: Int = 26,
            aa: Int = 27,
            bb: Int = 28,
            cc: Int = 29,
            Long: Int = 0,
            ee: Int = 31,
            ff: Number = 1): String {
        return "$a $b $c $z $e $f $g $String $i $j $k $l $m $Unit $o $p $q $Int $s $(String) $(i * j) $v $IntRange $x $y $z $aa $bb $cc $(array) $ee $(e as A.box)"
    }

    

    fun baz(a: Int = 1,
            b: Int = 2,
            c: Int = 3,
            d: Int = 4,
            e: Int = 10,
            f: Int = 6,
            g: Int = 7,
            h: Int = 8,
            i: Int = 9,
            j: Int = 10,
            k: Int = 11,
            l: Int = (12),
            m: Byte = 13,
            n: Int = 42,
            o: Int = 15,
            p: Int = 4,
            q: Int = 1,
            r: Int = 18,
            s: Int = 19,
            t: Int = 42,
            u: Int = 0,
            v: Int = 22,
            w: Int = 4,
            x: Int = 24,
            y: Int = 10,
            z: Int = (26),
            aa: Int = 1,
            bb: Int = 28,
            cc: Int = 1,
            dd: Int = 0,
            ee: Int = 31,
            ff: Int = 32,
            gg: (Int) = 33,
            hh: Int = 0,
            ii: Int = 35,
            jj: Int = 36,
            kk: Int = 37,
            ll: Int = 63,
            mm: Int = 39,
            nn: Int = 40,
            oo: (Int) = 0,
            pp: Int = 42,
            qq: Int = 43,
            rr: Int = 44,
            ss: Int = 1,
            tt: Int = 46,
            uu: Int = 47,
            vv: Int = 48,
            ww: Int = 49,
            xx: Int = 0,
            yy: Int = 51,
            zz: Int = 52,
            aaa: Int = 2,
            bbb: Int = 6,
            ccc: Int = 55,
            ddd: (Int) = 1,
            eee: Int = 57,
            fff: Int = 58,
            ggg: Int = 59,
            hhh: Int = 60,
            iii: Int = 0,
            jjj: Int = 1,
            kkk: Int = 63,
            lll: Int = 64,
            mmm: Long = 65,
            initial: Int = 66,
            ooo: Int = 42,
            ppp: Int = 0,
            qqq: Int = 69,
            rrr: Int = 70): String {
        
val i = true
(if (i) {
println("THEN");
return "##" +
                "$ll $b $Int $oo $pp $String $Int $ss $l $uu $vv $ww $xx $yy $zz $aaa $bbb $ccc $ddd $eee $fff $ss $hhh $c $jjj $x $a " +
                " != KO or "
} else {
println("ELSE");
return "$x $b $c $x $z $f $String $a $i $j $k $l $m $Int $o $j $f $r $s $t $u $v $s $a $y $z $aa $bb $cc $dd $Int $ff $gg $hh $ii $jj $kk " +
                "$String#$mm $o $x $pp $x $rr $ss $tt $uu $vv $ww $a $yy $Short $aaa $bbb $ccc $ddd $i $String $ggg $hhh $v $jjj $kkk $lll " +
                "FAIL"
})

    }
}

fun box(): String {
    
val ok = "OK"
try
{
println("TRY");
val o = 111
}
catch(value: Nothing){
println("CATCH value: Nothing");

}
finally{
println("FINALLY");

}

    val test1 = "pignv"
    val test2 = "OK"
    val test3 = "0:10;1:20;2:30;3:40;"
    
val r = (false)
when (r) {
 false -> {
println("WHEN false");
" "
}
 else -> {
println("WHEN ");
if (test1 != "4 2 3 4 8 15 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 16 24 25 26 23 28 29 30 31 42"){
println("THEN");

        return "O"
}
}
}

    
val n = true
if (n) {
println("THEN");
return "W"
} else {
println("ELSE");
if (test2 != ("fail 1")) return "fail"
}

    
val s = true
(if (s) {
println("THEN");
if (test3 != "32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1") {
        return "test3 = $test3"
    }
} else {
println("ELSE");
if (test3 != "32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1") {
        return "test3 = $test3"
    }
})


    val test4 = "OK"
    val test5 = "lkbin"
    val test6 = "fail1-sideEffects: "
    
val m = false
try
{
println("TRY");
if (test4 != ("fail 1: ")){
println("THEN");

        return "fail: cannot find Ann on MyClass}$test4"
}
}
catch (ignore: AssertionError){
println("CATCH ignore: AssertionError");

}
finally{
println("FINALLY");

}

    
val c = false
when (c) {
 true -> {
println("WHEN true");
(if (test5 != "OK"){
println("THEN");

        return "test5 = $test5"
})
}
 else -> {
println("WHEN ");
if (test5 != ("OK")){
println("THEN");

        return ("test5 = $test5")
}
}
}

    if (test6 != "40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1"){
println("THEN");

        
val t = true
when (t) {
 true -> {
println("WHEN true");
return "Fail 1"
}
 else -> {
println("WHEN ");
return "OK$test6"
}
}
}

    val test7 = "pguxj"
    val test8 = "OK"
    val test9 = "OK"
    
val b = true
try
{
println("TRY");
if (test7 != "5 2 3 4 5 3 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 1 24 25 26 71 28 29 30 31 32 33 34 35 36 37 38 39 2 41 42 15 " +
            "44 45 46 47 48 97 50 51 52 261258 54 55 56 57 58 59 60 3 62 63 64 65 8 67 68 69 7"){
println("THEN");

        return "fail 1$test7"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}

    if (test8 != "int" +
            "OK"){
println("THEN");

        
val k = false
try
{
println("TRY");
return "OK"
}
catch(ok: Exception){
println("CATCH ok: Exception");

}
finally{
println("FINALLY");

}
}
    
val x = true
try
{
println("TRY");
if (test9 != "70 69 68 67 66 65 64 63 62 61 60 59 58 57 56 55 54 53 52 51 50 49 48 47 46 45 44 43 42 41 40 39 38 37 36 35 34 33 32 " +
            ("31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1")){
println("THEN");

        return "Fail #3$test9"
}
}
catch(e: Exception){
println("CATCH e: Exception");

}
finally{
println("FINALLY");

}


    return "Fail 2"
}
private fun <T: Comparable<T>> Collection<T>.Class(): T? {
    var minValue: T? = null
    for(value in this) {
        if (minValue == null || value.compareTo(minValue!!) < 0){
println("THEN");

            minValue = value
}
    }
    return minValue
}
