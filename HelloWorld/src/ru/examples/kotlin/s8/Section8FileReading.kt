package ru.examples.kotlin.s8

import java.io.File

fun main() {

    // Kotlin has no own IO-classes.
    // Kotlin append number of useful classes
    // and add extensions to Java IO classes
    //https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/


    // Do not use this function for huge files. (see ReadWrite.kt )
    val linesList = File("testfile.txt").reader().readLines()
    linesList.forEach { println(it) }

    // want to get reader - close him after
    val reader = File("testfile.txt").reader()
    // equivalent in Java
    // new InputStreamReader(new FileInputStreamReader(new File("testfile.txt"), "UTF-8"))

    val linesString = reader.readText()
    reader.close()
    println(linesString)

    // All use-function close resource for us
    // equivalent in Java "try with resources"
    //     try( rf: FileReader = new FileReader()) { .. }
    val linesUse = File("testfile.txt").bufferedReader().use { it.readText() }
    println(linesUse)

    // ext for File()  (with limitation file size to 2Gb)
    val linesFile = File("testfile.txt").readText()
    println(linesUse)

    // read huge file line by line
    println("reading huge files")
    File("testfile.txt").forEachLine { println(it) }
    File("testfile.txt").reader().forEachLine { println(it) }
    File("testfile.txt").reader().useLines { it.forEach { println(it) } }
}