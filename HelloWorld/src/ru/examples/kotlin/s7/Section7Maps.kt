package ru.examples.kotlin.s7


fun main() {

    val car1 = Car("blue", "Hyundai", 2010)
    val car2 = Car("black", "Ford", 2009)
    val car3 = Car("white", "Hyundai", 2009)

    val mapOf = mapOf(1 to car1, 2 to car2, 3 to car3)
    //{1=Car(name=Hyundai, year=2010), 2=Car(name=Ford, year=2009), 3=Car(name=Hyundai, year=2009)}
    println(mapOf)
    println(mapOf.javaClass)  //class java.util.LinkedHashMap

    val mutableMapOf = mutableMapOf(1 to car1, 2 to car2, 3 to car3)
    mutableMapOf.put(4, Car("blue", "Toyota", 2008))
    //{1=Car(name=Hyundai, year=2010), 2=Car(name=Ford, year=2009), 3=Car(name=Hyundai, year=2009)}
    println(mutableMapOf)
    println(mutableMapOf.javaClass)  //class java.util.LinkedHashMap
    // Using LinkedHashMap for easy convert to list/array by Iterator,
    // that exist in LinkedHashMap

    val hashMapOf = hashMapOf(1 to car1, 2 to car2, 3 to car3)
    //{1=Car(name=Hyundai, year=2010), 2=Car(name=Ford, year=2009), 3=Car(name=Hyundai, year=2009)}
    println(hashMapOf)
    println(hashMapOf.javaClass)  //class java.util.HashMap
}

data class Car(val color: String, val name: String, val year: Int) {}