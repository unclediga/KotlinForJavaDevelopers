package ru.examples.kotlin.s7

import java.lang.StringBuilder

fun main() {
    val employees = listOf(
        Employee("Ivan", "Ivanov", 2010),
        Employee("Peter", "Petrov", 2012),
        Employee("Sidor", "Sidorov", 2019)
    )

    // concise way to write lambda
    // lambda must be latest param in function
    println(employees.maxBy({ e: Employee -> e.startYear }))
    println(employees.maxBy { e: Employee -> e.startYear })
    println(employees.maxBy { e -> e.startYear })
    println(employees.maxBy { it.startYear })

    // member reference
    println(employees.minBy(Employee::startYear))

    // closure (?)
    val num1 = 10  // Java:  final int num1
    var num2 = 10  // Java: error! Can't pass non final variable in anonymous class or lambda
    run {
        println("num1 = $num1")
        println("num2 = $num2") // 10
        println("new num2 = ${++num2}") // 11
    }
    println("num2 = $num2") // 11

    // lambda with receiver
    // Java Style
    println(countTo100J())
    // Kotlin Style
    println(countTo100K())
    println(countTo100K2())

    // lambda local return and labels
    /////////////////////////////////////////
    // ex 1
    val y = 2011

    // in first case just RETURN FROM main() !!!

//    employees.forEach {
//        if (it.startYear > y) {
//            println("ex1 ${it.lastName} start after ${y}")
//            return     //RETURN FROM main() !!!
//        }
//    }

//    run() {
//        employees.forEach {
//            if (it.startYear > y) {
//                println("ex1 ${it.lastName} start after ${y}")
//                return    //RETURN FROM main() !!!
//            }
//        }
//    }

    // will print only first case
    fun ex1() {
        employees.forEach {
            if (it.startYear > y) {
                println("ex1 ${it.lastName} start after ${y}")
                return // RETURN FROM ex1()
            }
        }
    }
    ex1()
    //ex1 Petrov start after 2011


    // will print all cases
    // local return from lambda
    fun ex2() {
        employees.forEach returnBlock@{
            if (it.startYear > y) {
                println("ex2 ${it.lastName} start after ${y}")
                return@returnBlock // RETURN FROM Lambda
            }
        }
    }
    ex2()
//    ex2 Petrov start after 2011
//    ex2 Sidorov start after 2011


    // ex 3
    "String1".apply str1@{
        "String2".apply {
            println(toUpperCase())   // STRING2
            println(this@str1.toUpperCase()) // STRING1
        }
    }


}

fun countTo100J(): String {
    val numbers = StringBuilder()
    for (i in 1..99) {
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}

fun countTo100K() =
    with(StringBuilder()) {
        // this => StringBuilder()
        for (i in 1..99) {
//                this.append(i)
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }

fun countTo100K2() =
    StringBuilder().apply {
        // this => StringBuilder()
        for (i in 1..99) {
//                this.append(i)
            append(i)
            append(", ")
        }
        append(100)
    }.toString()


data class Employee(val firstName: String, val lastName: String, val startYear: Int) {}