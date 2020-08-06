package ru.unclediga.kotlin

import java.io.File

fun readLocationInfo(): Map<Int, Location> {

    val locations = mutableMapOf<Int, Location>()

    File("locations_big.txt").reader().forEachLine {
        val tokens = it.split(",")
        var s = ""
        IntRange(1, tokens.size - 1).forEach {
            s += tokens[it]
        }
        val location = Location(tokens[0].toInt(), s)
        locations[location.locationID] = location
    }

    File("directions_big.txt").reader().forEachLine {
        val tokens = it.split(",")
        locations[tokens[0].toInt()]?.addExit(tokens[1],tokens[2].toInt())
    }

    return locations
}
