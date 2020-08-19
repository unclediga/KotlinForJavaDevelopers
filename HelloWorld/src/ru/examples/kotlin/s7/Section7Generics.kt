package ru.examples.kotlin.s7

import java.lang.StringBuilder

fun main() {
    val shorts = listOf<Short>(1, 2, 3, 4)
    val shortsWithNulls = listOf<Short?>(1, 2, 3, 4)
    val ints = listOf(10, 20, 30, 40)
    val longs: List<Long> = listOf(100L, 200L, 300, 400)
    val doubles: List<Double> = listOf(1.0, 2.2, -3.0, 4.2)
    val strings = listOf("assa", "bessa")
    val strings2 = listOf("dessa", "xilo")
    val strings3 = listOf("null", null)
    val stringsAny: Any = listOf("null", null)

    strings.printCollection()
    strings3.printCollection()
    strings.printCollectionNotNulls()
//    strings3.printCollectionNotNulls()  // Error: inferred type String? is not a subtype of Any


    append(StringBuilder(strings.toString()), StringBuilder(strings2.toString()))

    convertToInt(ints)
    convertToInt(doubles)
    convertToInt(longs)
    convertToInt(shorts)

//    convertToInt(shortsWithNulls)     // Error: inferred type Short? is not a subtype of Number
    convertToIntWithNulls(shortsWithNulls)

//    convertToInt(strings)            // Error: inferred type String is not a subtype of Number

    //////////////////////////////////////////////////
    //     TYPE ERASURE
    /////////////////////////////////////////////////
    // JAVA: NO Error
    // if (strings instanceof List) { ...
    // JAVA: Always be error
    // if (strings instanceof List<String>) { ...

    // NO Errors: compiler check types in compile-time
    if (strings is List<String>) {
        println("strings is List of Strings")
    }

    // ERROR : Cannot check for instance of erased type: List<String>
//    if (stringsAny is List<String>){
//        println("strings is List of Strings")
//    }

    // ERROR : One type argument expected. Use 'List<*>' if you don't want to pass type arguments
//    if (stringsAny is List){
//        println("strings is List of Strings")
//    }
    // Star Projection Syntax
    // type declaration is mandatory in Kotlin !!
    if (stringsAny is List<*>) {
        println("strings is a List")
    }
    if (stringsAny is List<*>) {
        val strList = stringsAny as List<String>  //Warning:(62, 34) Unchecked cast: Any to List<String>
        println(strList[0].toUpperCase())
        // RUNTIME ERROR: null cannot be cast to non-null type java.lang.String
        //println(strList[1].toUpperCase())
    }


    val mixedList: List<Any> = listOf(1, 2, "11", "22")

    // Reified type
    /////////////////////////////////////////////////

    // ordinary functions
    // prnMix<Number>(mixedList)  // Kotlin: Cannot check for instance of erased type: T

    // need two condition:
    //  1) declaring reified type
    //  2) inline function
    // All works!
    prnMixReifined<Number>(mixedList)    // el:1 el:2
    prnMixReifined<String>(mixedList)    // el:11 el:22

    // reified allow ONLY in inline functions!
    //    fun <reified T> someFunc()               --> ERROR!
    //    class <reified T> someClass {}           --> ERROR!
    //    inline fun <reified T> someFunc()        --> GOOD!
}


// Not null type
fun <T : Number> convertToInt(collection: List<T>) {
    for (num in collection) {
        println(num.toInt())
    }
}

// null is accepted
fun <T : Number?> convertToIntWithNulls(collection: List<T>) {
    for (num in collection) {
        println(num?.toInt())
    }
}

// extension function
fun <T> List<T>.printCollection() {
    for (el in this) {
        print("[${el}]")
    }
    println()
}

// extension function NOT NULL constrain
fun <T : Any> List<T>.printCollectionNotNulls() {
    for (el in this) {
        print("[${el}]")
    }
    println()
}

//  where-clause  and many types
fun <T> append(l1: T, l2: T)
        where T : CharSequence, T : Appendable {
    println("${l1.append(l2)}")
}

fun <T> prnMix(mixedList: List<Any>) {
    for (el in mixedList) {
//        if (el is T) {   // Kotlin: Cannot check for instance of erased type: T
//            println(el)
//        }
    }
}

inline fun <reified T> prnMixReifined(mixedList: List<Any>) {
    for (el in mixedList) {
        if (el is T) {
            println("el:${el}")
        }
    }
}

