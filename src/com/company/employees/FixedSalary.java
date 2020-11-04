package com.company.employees;

public class FixedSalary extends Employee {
    private final double salary;

    public FixedSalary(String firstName, String lastName, int salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getAverageMonthlySalary() {
        return salary;
    }

    public double getSalary() {
        return salary;
    }
}
