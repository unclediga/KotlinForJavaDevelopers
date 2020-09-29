package ru.example.java.s9.challenge2;

import ru.examples.kotlin.s9.challenge2.Challenge;
import ru.examples.kotlin.s9.challenge2.Employee;
import ru.examples.kotlin.s9.challenge2.KotlinStuff;

public class Main {
    public static void main(String[] args) {

        // Rename Kotlin file from default 'KotlinCodeKt' -> 'KotlinStuff'
        KotlinStuff.sayHelloToJava("Student");

        final Employee employee = new Employee("John", "Smith", 2018);
        // In Kotlin file change Property 'startYear':
        // 1) val -> var
        // 2)  add @JvmField for field-like access
        employee.startYear = 2019;

        // Force Kotlin compiler generate static method 'doMath(int, int)', but not instance method
        Challenge.doMath(4, 5);

        // fix it!
        // 'takesDefault(java.lang.String, java.lang.String)' in
        // 'ru.examples.kotlin.s9.challenge2.Employee' cannot be applied to '(java.lang.String)'
        employee.takesDefault("par1");
    }
}
