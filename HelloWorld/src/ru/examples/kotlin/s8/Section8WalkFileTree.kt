package ru.examples.kotlin.s8

import java.io.File

fun main() {

    // TopDown direction - A directories are visited before a files
    File(".").walkTopDown().forEach { println(it) }
    // show only Kotlin-files
    println("Kotlin only ==== ")
    File(".").walkTopDown()
        .filter { it.extension == "kt" }
        .forEach { println(it) }
}