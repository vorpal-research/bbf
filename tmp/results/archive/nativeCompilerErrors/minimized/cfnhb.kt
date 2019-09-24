
class Derived1 : Base {
inner class Derived2 : Base {
        val x = object : A by Derived1().Derived2().x {}
    }
}
