package ru.example.java.s9.challenge;

public class Employee {
    private String firstName;
    private String lastName;
    private int startYear;
    private float[] salaryLast3Years;

    public Employee(String firstName, String lastName, int startYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startYear = startYear;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
