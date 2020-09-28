package ru.examples.kotlin.s9

import ru.example.java.s9.Car

fun main() {
    var car = Car("blue","Ford",2015)
    // Compile error: Kotlin: Val cannot be reassigned
    car.color ="green"
    car.model = "Toyota"

    // No try-catch !
    // Kotlin does not distinguish between checked and unchecked exceptions
    car.throwException()

}