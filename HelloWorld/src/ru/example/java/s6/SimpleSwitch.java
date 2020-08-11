package ru.example.java.s6;

// see Section6_if_when.kt
public class SimpleSwitch {
    public static void main(String[] args) {
        final int n = 200;
        switch (n) {
            case 100:
                System.out.println("100");
                break;
            case 200:
                System.out.println("200");
                break;
            case 300:
                System.out.println("300");
                break;
            default:
                System.out.println("Doesn't match anything");
        }
    }
}
