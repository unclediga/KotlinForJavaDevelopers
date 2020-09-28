package ru.example.java.s9;

import org.jetbrains.annotations.NotNull;

public class Car {
    public static int x = 5;
    private String color;
    private String model;
    private int year;
    private Object anObject;

    public Car(String color, String model, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public static String xString() {
        return "x: " + x++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(@NotNull String color) {
        this.color = color;
    }

    public @NotNull String getModel() {
        return model;
    }

    // If no any annotations - @Nullable is default
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Object getAnObject() {
        return anObject;
    }

    public void setAnObject(Object anObject) {
        this.anObject = anObject;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    public void throwException() throws Exception {
        throw new Exception("Test");
    }

    public void variableMethod(int num, String ... strings){
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public void wantsIntArray(int[] nums){
        for (int num : nums) {
            System.out.println("num " + num);
        }
    }

    public void demoMethod(Runnable r){
        new Thread(r).start();
    }
}
