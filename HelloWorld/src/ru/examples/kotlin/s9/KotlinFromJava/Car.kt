@file:JvmName("StaticCar")
package ru.examples.kotlin.s9.KotlinFromJava

fun topLevel() = println("I am in the Car file!")

class Car(color:String, @JvmField val model:String, val year:Int, val isAutomatic: Boolean){
    var color:String = color
    set(value){
        field = "ever green!"
    }

    companion object{
        fun carComp() = println("I am in Car's companion object")
        @JvmStatic fun carComp2() = println("I am in Car's companion object (2)")
    }
}

fun String.print(){
    println(this)
}

fun main(){
    "Print this".print()
}