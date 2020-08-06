package ru.examples.kotlin.s5.add

import ru.examples.kotlin.s4.printStr
import ru.examples.kotlin.s5.Department
import ru.examples.kotlin.s5.Department.IT as itd
import ru.examples.kotlin.s4.printStr as psU
import ru.examples.kotlin.s5.upperFirts as uf


fun main() {

    printStr("test string")
    psU("test string")

    println(Department.ACCOUNTING.getDescription())
    println(itd.getDescription())

    println("string two".uf())
}