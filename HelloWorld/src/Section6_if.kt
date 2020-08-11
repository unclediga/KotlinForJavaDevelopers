package ru.examples.kotlin.s6

import java.lang.IllegalArgumentException
import java.math.BigDecimal
import javax.print.attribute.IntegerSyntax

fun main() {
    //////// if - expression //////////////

    // java ternary operator c?x:y NOT EXIST IN KOTLIN

    val cond = 234 > 200
    val x = if (cond) 50 else 100
    println("x = $x")
    val y = if (cond) {
        println("cond is true")
        50
    } else {
        println("cond is false")
        100
    }
    println("y = $y")

    val t = if (cond) {
        println("cond is true")
    } else {
        println("cond is false")
    }
    println("t = $t and type is ${t.javaClass}")
    // t = kotlin.Unit and type is class kotlin.Unit

    println("t == null ${(t == null)} t equal Unit ${t.equals(Unit)}")
    // t == null false t equal Unit true

    // see ru.example.java.s6.SimpleSwitch
    //////// W H E N //////////////////
    var n = 200
    when (n) {
        100 -> println("100")
        200 -> println("200")
        300 -> println("300")
        else -> println("doesn't match anything")
    }

    n = 250
    when (n) {
        100 -> println("100")
        in 200..300 -> println("200..300")
        else -> println("doesn't match anything")
    }

    val nn = 100
    n = 300
    when (n) {
        nn -> println("100")
        nn + 100 -> println("200")
        nn + 200 -> println("nn+200 = 300")
        else -> println("doesn't match anything")
    }
    /// Smart casting in WHEN
    val o1 = "hello"
    val o2 = BigDecimal(40.6)
    val o3 = 100
    var something: Any = o2
    when (something) {
        is String -> println(something.toUpperCase())
        is BigDecimal -> println(something.remainder(BigDecimal(2.0)))
        is Int -> println(something - 55)
    }


    val yy: Any = when (something) {
        is String -> {
            println(something.toUpperCase())
            something.toUpperCase()
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(2.0)))
            something.remainder(BigDecimal(2.0))
        }
        is Int -> {
            println(something - 55)
            something - 55
        }
        else -> Unit
    }
    println("yy = $yy")

    // exhaustive values. NOT NEED else SUBTREE
    val season = Season.AUTUMN
    val msg = when (season) {
        Season.SPRING -> "spring"
        Season.SUMMER -> "summer"
        Season.AUTUMN -> "autumn"
        Season.WINTER -> "winter"
        // no need else -> "..."
    }
    println(msg)

    // other way to if-else-if
    val yyy = 345
    when {
        yyy < 100 -> println("less 100")
        yyy > 100 -> println("greater 100")
        else -> println("equals 100")
    }

    ////// TRY - CATCH - FINALLY  ////////////
    fun parseI(str: String): Int? {
        return try {
            Integer.parseInt(str)
        }catch (e: NumberFormatException){
            null
        }finally {
            println("Hello from finally")
            // finally not ever evolved to return value
        }
    }

    // returning null - best option, when user can apply their own processing of an error
    println("25 = ${parseI("25")}")

    println("20.4 OR 0")
    println("${parseI("20.4") ?: 0}")

    println("20.4 OR String")
    println("${parseI("20.4") ?: "Number can't be parsed"}")

    println("20.4 OR Exc")
    println("${parseI("20.4") ?: throw IllegalArgumentException("Number can't be parsed")}")
}


enum class Season {
    SPRING, SUMMER, AUTUMN, WINTER
}