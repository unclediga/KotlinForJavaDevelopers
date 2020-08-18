package ru.examples.kotlin.s7

fun main() {

    // immutable
    val set = setOf(1, 2, 3, 4, 5)
    println(set.javaClass)           // class java.util.LinkedHashSet
    println(set.plus(10))    //    [1, 2, 3, 4, 5, 10]
    println(set.plus(5))     //    [1, 2, 3, 4, 5]
    println(set.minus(10))   //    [1, 2, 3, 4, 5]
    println(set.minus(5))    //    [1, 2, 3, 4]
    println(set.drop(3))          //    [4, 5]

    //mutable
    val mutableSet = mutableSetOf(1, 2, 3, 4, 5)
    println(mutableSet.javaClass)    // class java.util.LinkedHashSet
    mutableSet.plus(10)
    println(mutableSet)             //   (!!!) [1, 2, 3, 4, 5]
    mutableSet.add(10)
    println(mutableSet)             //        [1, 2, 3, 4, 5, 10]
}