@file:JvmName("KotlinStuff")
// rename Kotlin file from default 'KotlinCodeKt' -> 'KotlinStuff'

package ru.examples.kotlin.s9.challenge2

fun sayHelloToJava(name: String) {
    println("Hello to Java and $name")
}

object Challenge {
    // Force Kotlin compiler generate static method 'doMath(int, int)', but not instance method
    @JvmStatic fun doMath(x: Int, y: Int) = x * y
}

// In Kotlin file change Property 'startYear':
// 1) val -> var
// 2)  add @JvmField for field-like access
class Employee(val firstName: String, val lastName: String, @JvmField var startYear: Int) {
    //Force compiler generate two java-signature;
    // - void takesDefault(param1, param2)
    // - void takesDefault(param1)
    @JvmOverloads
    fun takesDefault(param1: String, param2: String = "default") {
        println("takes param1=$param1 and param2=$param2")
    }

}