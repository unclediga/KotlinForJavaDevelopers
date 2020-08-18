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

    // Destructuring Declaration (Pattern Matching ??)
    val p = Pair(10, "val=10")
    val (cons, corr) = p
    println("(${cons},${corr})") // (10,val=10)

    for ((_key, _val) in mapOf) {
        println("entry: ${_key} => ${_val}")
    }

    val (color, name, year) = car1
    println("Car (${color}, ${name}, ${year})")

    val (color2, name2, year2) = Car2("blue", "Toyota", 2008)
    println("Car2 (${color2}, ${name2}, ${year2})")
}

// For data classes componentX() are implemented for free!
data class Car(val color: String, val name: String, val year: Int) {}
// in ordinary class you must implement componentX() func to make use DD
class Car2(val color: String, val name: String, val year: Int) {
    operator fun component1() = color
    operator fun component2() = name
    operator fun component3() = year
}