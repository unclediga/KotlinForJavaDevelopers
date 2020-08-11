package ru.examples.kotlin.s6

fun main() {

    val range = 1..5
//    for(int i = 1; i < 6; i++)
    prnRange(range)
    prnRange(range.reversed())  // 54321
    prnRange(5.downTo(1))  // 54321
    prnRange(range.step(2)) //1 3 5

    println(4 in range) // true
    println(4 in range.reversed()) // true
    prnRange(range.reversed()) // 5..1
    prnRange(5..1) // null !!! NOT WORKED! YOU NEED  5.downTo(1)

    prnRange(1..30 step 3)
    prnRange(30 downTo 1 step 3)

    val charRange = 'a'..'z'
    println('q' in charRange) // true

    prnRange(charRange)
    val stringRange = "ABC".."XYZ"

    //prnRange(stringRange)  error
    println("CCCCC" in stringRange) // true
    println("ZZZZZ" in stringRange) // false

    prnRange("Hello!".toList())

    for (c in "Hello!\n") {
        print(c)
    }
    // exclusive [0..ln)
    for (i in 0 until "Hello!\n".length) {
        print("Hello!\n".get(i))
    }

    val seasons = arrayOf("spring", "summer", "autumn", "winter")
    println("'hello' in seasons = ${"hello" in seasons}")

    prnRange(seasons.toList())

    for (season in seasons) {
        println(season)
    }

    for (idx in seasons.indices) {
        println("seasons[$idx]=${seasons[idx]}")
    }
    // equals in ForEach(..)
    seasons.forEach { println("foreach.$it") }
    seasons.forEachIndexed { idx, value -> println("foreach.seasons[$idx]=${value}") }


    println("'e' !in 'Hello': ${'e' !in "Hello"}")
    println("32 !in 1..10: ${32 !in 1..10}")


    outer@
    while (true) {
        println("iter 1")
        while (true) {
            println("iter 2")
            while (true) {
                println("iter 3")
                break@outer
            }
        }
    }
}

fun <T> prnRange(r: Iterable<T>) {
    for (i in r) {
        print("[$i]")
    }
    println()

}

