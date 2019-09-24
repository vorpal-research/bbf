fun 
()  {
    fun A.foo() = ""
if (true) A::foo else (A::foo)()
}
class A
