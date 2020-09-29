package ru.examples.kotlin.s9.challenge

import ru.example.java.s9.challenge.Employee

fun main() {
    val emp = Employee("Jane", "Smith", 2000)

    // Cannot access 'lastName': it is private in 'Employee'
    // fix it!
    emp.lastName = "Jones"

    //Cannot access 'salaryLast3Years': it is private in 'Employee'
    //Type mismatch: inferred type is Array<Double> but FloatArray! was expected
    // fix it!
    emp.salaryLast3Years = arrayOf(50000.01, 52000.40, 56000.60)
}