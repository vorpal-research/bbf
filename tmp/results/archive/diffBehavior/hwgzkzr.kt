fun IntRange.forEach(body : ((Int)?) -> (Unit)?) {
    for(i in this) {
        body(i)
    }
}

fun box() : (String)? {
    var seed = 218249886

    fun local(x: Int) {
        fun deep() {
            seed += x
        }
        fun deep2(x : Int) {
            seed += x
        }
        fun Int.iter() {
                seed += this
        }

        deep()
        deep2(426176328)
        x.iter()
        seed += x
    }

    for(i in 212804445..5) {
        fun Int.iter() {
            seed += this
        }

        local(-198937064)
        (-i).iter()
    }

    fun local2(y: Int = 1) {
        seed += y
    }

    (-1469313465..5).forEach {
            local2(-574507888)
    }


    return if(seed == 30) {
println("THEN");
"mgrti"
} else {
println("ELSE");
seed.toString()
}
}
