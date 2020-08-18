package ru.examples.kotlin.s7

import java.util.ArrayList

fun main() {
    val lst = listOf("assa", "bessa", "dessa")
    pjc(lst) // class java.util.Arrays$ArrayList
    // <== class java.util.Arrays.asList();
    // Returns a fixed-size list backed by the specified array.
    // immutable !

    val emptyList = emptyList<String>()
    pjc(emptyList) // class kotlin.collections.EmptyList

    val listOfNotNull = listOfNotNull("assa", null, "bessa")
    pjc(listOfNotNull) //class java.util.ArrayList
    println("listOfNotNull ${listOfNotNull}") // [assa, bessa]

    val arrayList = arrayListOf<String>("assa", "bessa")
    arrayList.add("dessa")
    pjc(arrayList) // class java.util.ArrayList
    println(arrayList)

    val mutableListOf = mutableListOf<Int>(1, 2, 3)
    mutableListOf.add(4)
    pjc(mutableListOf) // class java.util.ArrayList
    println(mutableListOf)
    mutableListOf[1] = 20
    println(mutableListOf) //[1, 20, 3, 4]

    // Array to List
    val array = arrayOf("assa", "bessa", "dessa")
    pjc(array)         // class [Ljava.lang.String;
    val list1 = array.toList() // class java.util.ArrayList
    val list2 = listOf(*array) // class java.util.Arrays$ArrayList
    val list3 = listOf(array)  // class java.util.Collections$SingletonList
    pjc(list1)
    pjc(list2)
    pjc(list3)

    println(list1 + " " + list2) // !! [assa, bessa, dessa,  , assa, bessa, dessa]
    println("${list1} ${list2}") //  [assa, bessa, dessa] [assa, bessa, dessa]
    println(list3)  // [[Ljava.lang.String;@efb846] list of arrays<string>

    ////////// COLLECTIONS FUNCTIONS /////////////////////////////////////////
    val lst2 = listOf("red", "orange", "yellow", "green", "red", "yellow")
    println(lst2.getOrNull(123)) // null
    println(lst2.first())   //   red
    println(lst2.last())   //    yellow
    println(lst2.max())    //    yellow
    println(lst2.distinct()) //    [red, orange, yellow, green]
    println(lst2.asReversed()) //    [yellow, red, green, yellow, orange, red]

    //    [(red, assa), (orange, bessa), (yellow, dessa)]
    println(lst2.zip(lst))

    //(red, assa) =>class kotlin.Pair
    println("${lst2.zip(lst).get(0)} =>${lst2.zip(lst).get(0).javaClass}")

    //    [[assa, bessa, dessa], [red, orange, yellow, green, red, yellow]]
    println(listOf(lst, lst2))

    //    [assa, bessa, dessa, red, orange, yellow, green, red, yellow]
    println(lst + lst2)

    //    [assa, bessa, dessa, red, orange, yellow, green]
    println(lst.union(lst2))

}

fun pjc(o: Any) {
    println("${o.javaClass}")
}