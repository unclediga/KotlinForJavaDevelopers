package ru.example.java.s9.KotlinFromJava;

import ru.examples.kotlin.s9.KotlinFromJava.Car;
import ru.examples.kotlin.s9.KotlinFromJava.StaticCar;

public class Main {
    public static void main(String[] args) {
        StaticCar.topLevel();
        StaticCar.print("print java string");

        final Car car = new Car("blue", "BMW", 2011, true);

        // System.out.println(car.getModel());   -> error
        System.out.println(car.model);

        // Compile error: val color -> no setters
        // System.out.println(car.setModel());
        System.out.println(car.getColor());
        car.setColor("grey");
        System.out.println(car.getColor()); // "ever green!"
        System.out.println(car.isAutomatic());  // not getIsAutomatic() !

    }
}
