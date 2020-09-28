package ru.examples.kotlin.s9

import ru.example.java.s9.Car

fun main() {
    var car = Car("blue","Ford",2015)

    // No Errors
    car.model = null;

    // No Errors
    car.color ="green";

    // RunTime Error
    // Exception in thread "main" java.lang.IllegalArgumentException:
    // Argument for @NotNull parameter 'color' of ru/example/java/s9/Car.setColor must not be null
    car.color = null;


}