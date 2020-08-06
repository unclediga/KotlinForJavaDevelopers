package ru.examples.kotlin.s3
// Type Aliases
typealias EMSet = MutableSet<Employee>
typealias ESet = Set<Employee>

// 3. Basic Differences Between Kotlin and Java

fun main(args: Array<String>) {
    // Section 3
    // Basic Differences Between Kotlin and Java

    // Type Aliases
    val employees: EMSet = mutableSetOf()
    val assa1 = Employee("Assa", 1)
    val assa1dub = Employee("Assa", 1)
    val assa1ref = assa1
    val assa2 = Employee("Assa", 2)
    val bessa3 = Employee("Besa", 3)
    val bessa4 = Employee("Besa", 4)

    employees.add(assa1)
    employees.add(bessa3)
    println(employees)

    var employees2: ESet = HashSet()
    employees2 = employees2.plus(assa1)
    employees2 = employees2.plus(bessa4)
    println(employees2)


    // Referential Equality
    println("assa1 === assa1 ${assa1 === assa1}")
    println("assa1 === assa1ref ${assa1 === assa1ref}")
    println("assa1 === assa1dub ${assa1 === assa1dub}")
    println("assa1 === assa2  ${assa1 === assa2}")
    // Structural equality
    println("assa1 == assa1 ${assa1 == assa1}")
    println("assa1 == assa1ref ${assa1 == assa1ref}")
    println("assa1 == assa1dub ${assa1 == assa1dub}")
    println("assa1 == assa2  ${assa1 == assa2}")



    // Smart casing
    var emp: Any
    var emp2: Any
    emp = assa1
    emp2 = bessa3
    if(emp.hashCode() > 1){
        emp = "Hello"
        emp2 = "Hello, too"
    }
    if (emp is Employee) {
        println(emp.name)  // Smart casing
//        println(emp2.name)  // error
    }

    // String template
    println("Assa is $assa1")
    println("Assa id is ${assa1.id}")
    println("1/3 is ${1.0 / 3.0}")

    // Raw (triple) strings
    println("c:\\WORK\\Java")
    println("""c:\WORK\Java""")
    var str = """
                  |One line
       |Two line 
|Three line""".trimMargin()
    println("[$str]")

    str = """
                  One line
       |Two line 
Three line""".trimMargin()
    println("[$str]")

}

class Employee(var name: String, val id: Int) {
    override fun toString(): String {
        return "Employee(name='$name', id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (name != other.name) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }
}
