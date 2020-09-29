package ru.example.java.s9.challenge2;

import ru.examples.kotlin.s9.challenge2.Challenge;
import ru.examples.kotlin.s9.challenge2.Employee;

public class Main {
    public static void main(String[] args) {

        KotlinStuff.sayHelloToJava("Student");

        final Employee employee = new Employee("John", "Smith", 2018);
        employee.startYear = 2019;

        Challenge.doMath(4, 5);

        employee.takesDefault("par1");
    }
}
