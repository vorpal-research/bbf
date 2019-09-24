fun testFun1(str: String) {
    listOf(1, 2).map {
        class Local {
            fun foo() = str
        }
        Local()
    }
}
