package ru.unclediga.kotlin

fun main(args: Array<String>) {

    val locations = readLocationInfo()
    var loc = 64

    while (true) {

        val location = locations[loc] ?: Location(0, "Sorry!")

        println(location.description)
        if (loc == 0)
            break;

        print("Available exits are ")
        location.exits.keys.forEach {
            print("$it, ")
        }
        println()
        val line = readLine()?.toUpperCase() ?: "Z"

        if (location.exits.keys.contains(line)) {
            loc = location.exits[line]!!
        } else {
            println("Not existed choice")
        }
    }
}