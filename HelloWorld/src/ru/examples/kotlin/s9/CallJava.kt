package ru.examples.kotlin.s9

import ru.example.java.s9.Car

fun main() {
    var car = Car("blue","Ford",2015)

    // No Errors
    //car.model = null;

    // No Errors
    car.color ="green";

    // RunTime Error
    // Exception in thread "main" java.lang.IllegalArgumentException:
    // Argument for @NotNull parameter 'color' of ru/example/java/s9/Car.setColor must not be null

    //car.color = null;

    /////////////////////
    var model1 = car.model
    println(model1.javaClass) // java.lang.String
    model1 = null
    println(car)

    var model2:String = car.model
    println(model2.javaClass) // java.lang.String
    // Compilation error:
    //model2 = null
    println(model2)

    var model3:String? = car.model
    // Compilation error:   because (?) - exclusively Kotlin class (String?:Any), not Java-class
    //Kotlin: Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    //println(model3.javaClass)
    model3 = null
    println(model3)

}