package ru.example.java;

public class Dummy {
    public void sayBoolean(boolean val) {
        if (val)
            System.out.println("dummy say true");
        else
            System.out.println("dummy say false");
    }

    public void printArray(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + (i != a.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public void addTenToArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + 10;
        }
    }
}
