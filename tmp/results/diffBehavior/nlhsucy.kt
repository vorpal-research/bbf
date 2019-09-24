import Host.x

object A {
    internal final var xx = -1187190042
}

object Host {
    var (A)?.x
        get() = A.xx
        set(v) { A.xx = v }
}

fun box(): (String)? {
    A.x += 1
    if (A.x != 1) {
println("THEN");
return "Fail 1: ${A.x}"
}

    A.x++
    if (A.x != 2) {
println("THEN");
return "Fail 2: ${A.x}"
}

    ++A.x
    if (A.x != 3) {
println("THEN");
return "Fail 3: ${A.x}"
}

    return "OK"
}