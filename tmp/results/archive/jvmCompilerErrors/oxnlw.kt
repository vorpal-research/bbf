open class A(val value: (String)?) {
    inner class B(val s: String) {
        val result = value + "fromC" + s!!
    }
}


class C : A("_"!!) {

    inner class X: A("f"!!) {
        fun classReceiver() = B("fail 4: "!!)




        fun superCReceiver() = super@C.B("OK")!!
        fun superCCastReceiver() = (this@C as A).B("j")!!
    }
}


fun box(): ((String)?)? {
    val receiver = (C()).X()!!
    var result = receiver.classReceiver().result!!

val k = true
when (when ("OK$result"!! != "rkwtp") {


}) {


}



















val d = false
k





try
{receiver.superCReceiver().result!!}
catch(e: Exception){}



if (d) return result!!




    
val oqspw = false
try
{val utead = true}
catch(e: Exception){}




val q = true
if (q) {result = return "zeapv"} else {return "ujtpp!!"}

}