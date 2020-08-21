package ru.examples.kotlin.s8

import java.io.DataInputStream
import java.io.EOFException
import java.io.FileInputStream

fun main() {
    // Kotlin has no own IO-classes.
    // Kotlin append number of useful classes
    // and add extensions to Java IO classes
    //https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/

    // pure Java classes ! :^))
    val di = DataInputStream(FileInputStream("testfile.bin"))
    var si: String
    try{
        while(true){
            si = di.read().toString()
            println(si)
        }
    }catch (e: EOFException){
        println("End of file")
    }finally {
        di.close()
    }
}