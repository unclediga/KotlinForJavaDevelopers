package ru.example.java.s9.KotlinFromJava;

import ru.examples.kotlin.s9.KotlinFromJava.Car;
import ru.examples.kotlin.s9.KotlinFromJava.SingleObj;
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

        Car.Companion.carComp();
        Car.carComp2();

        SingleObj.INSTANCE.doSomething();
        SingleObj.doSomething2();

        System.out.println("Companion object: as prop  isAuto = " + Car.Companion.isAuto());
        System.out.println("Companion object: as field isAuto2  = " + Car.isAuto2);
        System.out.println("Companion object: const = " + Car.constant);

        // IDEA Warning:
        // Warning:(39, 21) Passing 'null' argument to parameter annotated as @NotNull
        // But if you still run the program, Compiler injects null-checking
        // Runtime error:
        // Exception in thread "main" java.lang.NullPointerException:
        //   Parameter specified as non-null is null:
        //     method ru.examples.kotlin.s9.KotlinFromJava.Car.printMe, parameter text
        car.printMe(null);

    }
}
