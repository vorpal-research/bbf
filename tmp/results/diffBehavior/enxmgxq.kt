class A {
    operator fun component1() = 1
    
}


fun box() : String {
    var (a, b) = A()

    val local = object {
        public fun run() {
            a = 3
        }
    }
    local.run()
    return ""
}
operator  fun A.component2() = 2
