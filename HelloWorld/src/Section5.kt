package ru.examples.kotlin.s5

import java.lang.StringBuilder

// why const - see Ken Kousen book
const val MY_CONST = 100L

// 5. OO and Kotlin Classes, Functions, Inheritance
fun main() {
    val emp = Employee("John")
    println(emp.firstName)
    println(emp.fullTime)

    val emp2 = Employee("Jane", false)
    println(emp2.firstName)
    println(emp2.fullTime)

    println(Demo().msg)

    val emp3 = Employee_II("Jack", false)
    println("emp3: ${emp3.firstName} ${emp3.fullTime}")
    emp3.fullTime = true;
    println("emp3: ${emp3.firstName} ${emp3.fullTime}")

    val car1 = Car("Hyundai", 2010)
    val car2 = Car("Ford", 2009)
    val car3 = Car("Hyundai", 2009)
    println("1 - 2 ${car1 == car2}")
    println("1 - 3 ${car1 == car3}")

    // structural equal(), copy() and toString() for free!
    val car4 = car3.copy(year = 2010)
    println("1 - 4 ${car1 == car4}") // true

    val emp4 = Employee("Jane", false)
    println("e2 - e4 ${emp2 == emp4}") // false

    printCarsAndLabel(car1, car2, label = "Cars:")
    printLabelAndCars("Cars:", car1, car2)

    val cars12 = arrayOf(car1, car2)
    val cars3 = arrayOf(car3)
    printLabelAndCars("Cars:", *cars12, *cars3)

    val allcars = arrayOf(*cars12, *cars3, car4)
    printLabelAndCars("Cars:", *allcars)

    val str = "my string"
    println("ext func : '$str' => '${str.upperFirts()}'")

    // 'this' is not required
    fun Car.nameInUpperCase(): String {
        return name.toUpperCase()
    }
    println(car4.nameInUpperCase())
}

fun printCarsAndLabel(vararg cars: Car, label: String) {
    println(label)
    for (car in cars) {
        println(car)
    }
}

fun printLabelAndCars(label: String, vararg cars: Car) {
    println(label)
    for (car in cars) {
        println(car)
    }
}

class Demo {
    val msg: String

    constructor() {
        msg = "Hello from Dummy!"
    }
}

//class Employee (firstName: String){
//    val firstName: String
//
//    init {
//        this.firstName = firstName
//    }
//}

//class Employee constructor(firstName: String){
//    val firstName: String
//
//    init {
//        this.firstName = firstName
//    }
//}

//class Employee constructor(firstName: String){
//    val firstName: String = firstName
//}

//class Employee constructor(val firstName: String){
//}

////    !!! END UP !!!
//class Employee(val firstName: String){
//}

// ERR in (val in Secondary constr is not allowed) need delegate to Primary constructor
//class Employee(val firstName: String){
//    constructor(val firstName: String, val fullTime: Boolean){
//    }
//}


// TODO:  -Error ??? Why ????
// var fullTime: Boolean?

//class Employee(val firstName: String) {
//    var fullTime: Boolean = true
//
//    constructor(firstName: String, fullTime: Boolean) : this(firstName) {
//        this.fullTime = fullTime
//    }
//}

class Employee(val firstName: String, var fullTime: Boolean = true) {

}

class Employee_II(val firstName: String, fullTime: Boolean = true) {
    var fullTime: Boolean = fullTime
        // ERROR - cannot access private 'fullTime'
//    private var fullTime: Boolean = fullTime
        get() {
            println("using getter for fullTime")
            return field
        }
        set(value) {
            println("using setter for fullTime")
            field = value
        }
}

data class Car(val name: String, val year: Int)

// extension functions
fun String.upperFirts(): String {
    val builder = StringBuilder(length)
    for (s in split(" ")) {
        builder.append(s.substring(0, 1).toUpperCase() + s.substring(1) + " ")
    }
    return builder.toString().trim()
}


