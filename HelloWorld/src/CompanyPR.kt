package ru.examples.kotlin.s5

import java.time.Year

fun main() {
    println(CompanyPR.companyName())
    println(SomeClass.accessPrivateVar())
//    println(SomeClass.Companion.accessPrivateVar())  - default with not named companion object
//    println(SomeClass.SomeCompanion.accessPrivateVar())  - companion have name 'SomeCompanion'

    // PATTERN FACTORY
//    val class2 = SomeClass2("my string")  - ERR
    val sc2asIs: SomeClass2 = SomeClass2.asIs("My string");
    println(sc2asIs.someString)
    val sc2lower: SomeClass2 = SomeClass2.conv("My string", false);
    println(sc2lower.someString)

    // Anonymous classes
    var vv = 1
    prnInterface(object:SomeInterface{
        override fun conv(num: Int): String {
            vv++ // can't do this in java
            return "val = ${num + 100}"
        }
    })
    println("vv = $vv")

    println(Department.IT.getDescription())
}

///// Singleton
object CompanyPR {
    val year: Year = Year.now()

    fun companyName() = "Mega Company"
}

///// Companion
// (see: SomeClass, SomeOtherClass. And java static method call  SomeClass.accessPrivateVar())
class SomeClass {
    companion object /* default name 'Companion' */ {
        private val privateVar = 6

        fun accessPrivateVar(): String = "Access private static var:$privateVar"
    }
}

// Pattern Factory
class SomeClass2 private constructor(val someString: String) {
    companion object {
        fun asIs(str: String): SomeClass2 = SomeClass2(str)
        fun conv(str: String, lowerCase: Boolean): SomeClass2 {
            if (lowerCase) {
                return SomeClass2(str.toLowerCase())
            } else {
                return SomeClass2(str.toUpperCase())
            }
        }
    }
}

interface SomeInterface {
    fun conv(num: Int): String
}

fun prnInterface(obj: SomeInterface){
    println(obj.conv(10))
}

enum class Department(val fullName: String, val empNum: Int) {
    HR("Human Resources", 2),
    IT("Information Technology", 5),
    ACCOUNTING("Accounting", 10),
    SALES("Sales", 15);

    fun getDescription(): String = "Name '$fullName' emps = $empNum"
}

