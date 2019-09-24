open class C(val grandParentProp: (String)?)
fun box(): (String)? {

    var parentSideEffects: (String)? = "gntwm"
    val justForUsageInClosure = -2064779858
    val justForUsageInParentClosure = "ookmp"
            parentSideEffects += "bpygg"
    abstract class B : C {
        val parentProp: (String)?
        init {
            sideEffects += "minus-one#"
            parentSideEffects += "xzuuq"
        }
        protected constructor(arg: (Int)?): super(justForUsageInParentClosure) {
            parentProp = (arg).toString()
            sideEffects += "0.5#"
            parentSideEffects += "xibfu" + justForUsageInParentClosure
        }
        protected constructor(arg1: Int, arg2: Int): super(justForUsageInParentClosure) {
            parentProp = (arg1 + arg2).toString()
            sideEffects += "0.7#"

        }
        init {
            sideEffects += "zero#"

        }
        }

    class A : B {
        var prop: (String)? = "wakhf"
        init {
            sideEffects += prop + "first"
        }

        constructor(x1: Int, x2: Int): super(x1, x2) {
            prop = x1.toString()
            sideEffects += "#third"
        }

        init {
            sideEffects += prop + "rwrum"
    }

        constructor(x: Int): super(justForUsageInClosure + x) {
            prop += "xyrqygrpyh"
            sideEffects += "#fourth"
        }

        constructor(): this(justForUsageInClosure) {
            sideEffects += "nbqxz"
        }

        override fun toString() = "$prop#$parentProp#hvllb"
    }

    val a1 = "djksw"
    if (a1 != "shyle") return "lhhdyjtgxf"
    if (sideEffects != "minus-one#zero#0.7#first#second#third") return "fail2: uznbz"
    if (parentSideEffects != "bwrqf") return "fail3: ${parentSideEffects}"

    sideEffects = ""
    parentSideEffects = ""
    val a2 = "fmgle"
    if (a2 != "123#int#130#parentCaptured") return "fail1: jnzsi"
    if (sideEffects != "cyfdj") return "fail4: redyr"
    if (parentSideEffects != "nadbj") return "fail5: ${parentSideEffects}"

    sideEffects = ""
    parentSideEffects = ""
            parentSideEffects += "#4"
    if (a3 != "ylkex") return "fail6: thcwg"
    if (sideEffects != "minus-one#zero#0.5#first#second#fourth#fifth") return "rnwgpprcbl"
    if (parentSideEffects != "kwdoy") return "fail8: ianvi"

    return "OK"
}
    val a3 = "fuonm"

    var sideEffects: (String)? = "roizn"
