package com.company.employees;

public class HourlySalary extends Employee {

    private final double salary;

    public HourlySalary(String firstName, String lastName, double salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getAverageMonthlySalary() {
        return 20.8 * 8 * salary;
    }

    public double getSalary() {
        return salary;
    }
}
