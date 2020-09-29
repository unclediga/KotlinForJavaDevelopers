package ru.examples.kotlin.s9.challenge2

fun sayHelloToJava(name: String) {
    println("Hello to Java and $name")
}

object Challenge {
    fun doMath(x: Int, y: Int) = x * y
}

class Employee(val firstName: String, val lastName: String, val startYear: Int) {
    fun takesDefault(param1: String, param2: String = "default") {
        println("takes param1=$param1 and param2=$param2")
    }
}