package ru.examples.kotlin.s5

fun main() {
    val laserPrinter = LaserPrinter("HP 123", 15)
    laserPrinter.printModel()
    println("Best price ${laserPrinter.bestPrice()}")
    val se = SomethingElse("Hello!", 12)
    val se2 = SomethingElse(253)
    se.prn()
    se2.prn()

    val ec = EndClass(123)
    ec.prnSub()
}

abstract class Printer(val modelName: String) {
    open fun printModel() = println("The model is ${modelName}")
    abstract fun bestPrice(): Double
}

open class LaserPrinter(modelName: String, ppm: Int) : Printer(modelName) {
    final override fun printModel() = println("The laser model is $modelName")
    override fun bestPrice() = 123.45
}

class SpecialLaserPrinter(val num: Int, modelName: String, ppm: Int) : LaserPrinter(modelName, ppm) {
//    override fun printModel() = println()   ERR
}

open class Something(val x: Int) {
    var someProp: String = "assa"

    constructor(str: String, y: Int) : this(y) {
        someProp = str
    }

    fun prn() = println(" ${someProp} ${x}")
}

class SomethingElse(y: Int) : Something(y) {

    constructor(somePar: String, y: Int) : this(y) {
        someProp = somePar
    }

}

interface MyInterface {
    val num1: Int
    val num2: Int
    fun prn()
}

interface MySubInterface:MyInterface {
    override val num2: Int
        get() = 25
    fun prnSub()
}

class EndClass(override val num1:Int):MySubInterface{
//        override val num1: Int = 50

    override fun prnSub() {
        prn()
    }

    override fun prn() {
        println("${num1} ${num2}")
    }
}


