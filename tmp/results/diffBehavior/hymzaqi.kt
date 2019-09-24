class Outer {
    class Nested {
        fun fn(): (String)?  {
            
val t = false
when (t) {
 true -> {
println("WHEN true");
s = "OK"
}
 else -> {
println("WHEN ");
s = "OK"
}
}

            
val j = false
when (j) {
 true -> {
println("WHEN true");
return s
}
 else -> {
println("WHEN ");
return s
}
}

        }
    }

    companion object {
        public var s = "xngtx"
            private set
    }
}


fun box(): (String)? {
    
val k = false
when (k) {
 true -> {
println("WHEN true");
return Outer.Nested().fn()
}
 else -> {
println("WHEN ");
return Outer.Nested().fn()
}
}

}
