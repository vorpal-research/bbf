interface B
fun <T> bar(x: T)  where T : A
, T : B = TODO
class C : A, B?
fun 
()  = bar(C())