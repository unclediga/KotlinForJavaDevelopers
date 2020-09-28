@file:JvmName("StaticCar")
package ru.examples.kotlin.s9.KotlinFromJava

fun topLevel() = println("I am in the Car file!")

class Car(color:String, @JvmField val model:String, val year:Int, val isAutomatic: Boolean){
    var color:String = color
    set(value){
        field = "ever green!"
    }
}

fun String.print(){
    println(this)
}

fun main(){
    "Print this".print()
}