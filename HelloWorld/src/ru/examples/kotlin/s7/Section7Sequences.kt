package ru.examples.kotlin.s7

fun main() {

    val cars =
        mapOf(
            1 to Car("blue", "Hyundai", 2010),
            2 to Car("black", "Ford", 2009),
            3 to Car("white", "Hyundai", 2009),
            4 to Car("yellow", "Hyundai", 2015),
            5 to Car("white", "Ferrari", 2016)
        )

    // Sequences -  analog of streams for JDK 1.7 and above


    val cars1 = cars.filter { it.value.name == "Hyundai" }.map { it.value.color }
    println(cars1.javaClass)  // class java.util.ArrayList
    println(cars1)           // [blue, white, yellow]

    val carsSeq = cars.asSequence()
        .filter { println("filtering ${it}"); it.value.name == "Hyundai" }
        .map { println("mapping ${it}"); it.value.color }
    println(carsSeq.javaClass)   // class kotlin.sequences.TransformingSequence
    println(carsSeq)             // kotlin.sequences.TransformingSequence@f49f1c

    // lazy evaluation
    // It's need for apply Terminal operation to run an evaluation of a sequence
    println("apply the terminal operation")
    val cars3 = carsSeq.toList()
    /*
    ...
    apply the terminal operation
    filtering 1=Car(color=blue, name=Hyundai, year=2010)
    mapping 1=Car(color=blue, name=Hyundai, year=2010)
    filtering 2=Car(color=black, name=Ford, year=2009)
    filtering 3=Car(color=white, name=Hyundai, year=2009)
    mapping 3=Car(color=white, name=Hyundai, year=2009)
    filtering 4=Car(color=yellow, name=Hyundai, year=2015)
    mapping 4=Car(color=yellow, name=Hyundai, year=2015)
    filtering 5=Car(color=white, name=Ferrari, year=2016)
    class java.util.ArrayList
    [blue, white, yellow]
    */
    println(cars3.javaClass)       // class java.util.ArrayList
    println(cars3)                // [blue, white, yellow]
}

