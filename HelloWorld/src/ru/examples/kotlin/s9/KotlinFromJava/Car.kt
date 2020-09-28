@file:JvmName("StaticCar")
package ru.examples.kotlin.s9.KotlinFromJava

fun topLevel() = println("I am in the Car file!")

class Car(val color:String, val model:String, val year:Int){

}

fun String.print(){
    println(this)
}

fun main(){
    "Print this".print()
}