package ru.examples.kotlin.s9.challenge

import ru.example.java.s9.challenge.Employee

fun main() {
    val emp = Employee("Jane", "Smith", 2000)

    // need both set and get methods for using dot-notation in Kotlin
    emp.lastName = "Jones"

    //add both set and get methods for using dot-notation
    //change type Array<Double> -> Array<Float> and cast to  array of primitive float
    // var 1
    emp.salaryLast3Years = arrayOf(50000.01f, 52000.40f, 56000.60f).toFloatArray()
    // var 2
    emp.salaryLast3Years = floatArrayOf(50000.01f, 52000.40f, 56000.60f)
}