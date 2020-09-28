package ru.examples.kotlin.s9

import ru.example.java.s9.Car

fun main() {
    var car = Car("blue","Ford",2015)
    // Compile error: Kotlin: Val cannot be reassigned
    car.color ="green"
    car.model = "Toyota"

    // No try-catch !
    // Kotlin does not distinguish between checked and unchecked exceptions
    //car.throwException()

    car.variableMethod(5, "hello", "goodbye")
    val  strings = arrayOf("hello", "goodbye")

    // Compile error: Type mismatch: inferred type is Array<String> but String! was expected
    // car.variableMethod(10, strings)

    // Use spread operator!
    car.variableMethod(10, *strings)

    // Pass primitive array

    // Type mismatch: inferred type is Array<Int> but IntArray! was expected
    //car.wantsIntArray(arrayOf(1,2,3))
    car.wantsIntArray(arrayOf(1,2,3).toIntArray())
    car.wantsIntArray(intArrayOf(1,2,3))

    // if need java.lang.Object methods
    (car.anObject as java.lang.Object).notify()
}