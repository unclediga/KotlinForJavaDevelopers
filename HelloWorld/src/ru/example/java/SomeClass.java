package ru.example.java;

public class SomeClass {
    private static int privateVar = 6;

    public static void accessPrivateVar() {
        System.out.println("Access private static var:" + privateVar);
    }

    public static void main(String[] args) {
        new SomeOtherClass().someMethod();
    }
}
