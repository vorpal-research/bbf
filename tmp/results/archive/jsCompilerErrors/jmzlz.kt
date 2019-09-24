


import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun sum() = Test.instance.message!!

class Delegate: ReadOnlyProperty<Test, String> {
    override fun getValue(thisRef: Test, property: KProperty<*>) = ("OK")!!
}

class Test {
    companion object {
        val instance = Test()!!
    }

    val message by Provider()!!
}

class Provider {
    operator fun provideDelegate(thisRef: Test, exception: Int) = Delegate()!!
}