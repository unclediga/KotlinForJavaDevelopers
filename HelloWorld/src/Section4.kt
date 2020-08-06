package ru.examples.kotlin.s4

import ru.example.java.Dummy

// 4. Data Types and Null Reference Handling
fun main(args: Array<String>) {
    //Section 4
    //Data Types and Null Reference Handling

    //no automatically cast to a wider type
    val myInt = 5
    var myLong = 11L
    // myLong = myInt  err
    myLong = myInt.toLong()

    // Arrays
    var a = arrayOf(1L, 2L, 3L)
    var b = arrayOf<Long>(1, 2, 3)
    var c = arrayOf(1, 2, 3)
    println(a.javaClass)
    println(b.javaClass)
    println("b is Array<Long> => ${a is Array<Long>}")
    println("c is Array<Long> => ${c is Array<Int>}")

    val a16 = Array(16) { idx -> "index=${idx}" }
    println("a16 size=${a16.size} and a16[10]='${a16[10]}'")
    val zeroA = Array(16) { 0 }
    println("zeroA size=${zeroA.size} and zeroA[10]='${zeroA[10]}'")

    val mixedA = arrayOf<Any>("hello", 22, true)
    println("mixedA is Array<Any> => ${mixedA is Array<Any>}")

    val mixedA2 = arrayOf("hello", 22, true)
    println("mixedA is Array<> => ${mixedA is Array<Any>}")

    // exchange primitive java types

    val bo = true
    Dummy().sayBoolean(bo)

    val intA = intArrayOf(1, 2, 3)
    val intA2 = arrayOf(1, 2, 3)
    Dummy().printArray(intA)
    //Dummy().printArray(intA) err

//    int[] a = new int[5];  - accepted in Java
//    val intA3 = Array<Int>(5) error
//    see arrayOfNulls()
    val intA3 = IntArray(5)  // int[5]
    Dummy().printArray(intA3) // print all zero
    // Array() -> IntArray()
    Dummy().printArray(intA2.toIntArray())

    Dummy().addTenToArray(intA)
    val intA4: Array<Int> = intA.toTypedArray()
    intA4.forEach { println(it) }

    // Safe operator

//    val str: String = null  err
    val str: String? = null
//    str.toUpperCase()  err
    // VAR 1
    if (str != null) {
        str.toUpperCase()
    }
    // VAR 2 -  more concise
    str?.toUpperCase()

    // Elvis operator

    val str2 = str?.toUpperCase() ?: "DEFAULT"
    println(str2)

    // Safe cast operator

//    val strA = intA as String  // java.lang.ClassCastException: [I cannot be cast to java.lang.String
    val strA = intA as? String
    println("strA = ${strA}")

    // Not-null assertion

    try {
        str!!.toUpperCase()  // !!! NPE ->  kotlin.KotlinNullPointerException
    } catch (e: Exception) {
        println("Exception ${e}")
    } finally {
        println("finally")
    }

    val strB: String? = null
    // val strC:String = strB!! //    kotlin.KotlinNullPointerException
    // In this chain the source on NPE is undefined. Don`t see in logs
    // bank!!address!!country - Don't do that!


    //         let - expression
    // if args is null - don't call function
    // printStr(strB)    Error:(98, 14) Kotlin: Type mismatch: inferred type is String? but String was expected
//     printStr(strB!!)  kotlin.KotlinNullPointerException
    strB?.let { printStr(it) }

    // equals() is safe  in Kotlin
    println("strB == strA -> ${strB == strA}")

    // Arrays of nulls
    // can't create array of object type
//    Array<Int>(5)  error
//    Array<Int?>(5) error

    // arrays of primitives have initial values
    val aon1 = arrayOfNulls<Int>(5)
    val aon2 = arrayOfNulls<Int?>(5)
    val aon3 = Array<Int?>(5){it -> null}
//    val aon4 = Array<Int>(5){it -> null}   Error
    aon1.forEach { println(it) }
    println("---------------")
    aon2.forEach { println(it) }
    println("---------------")
    aon3.forEach { println(it) }

}

fun printStr(a: String) {
    println(a.toUpperCase())
}
