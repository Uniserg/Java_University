package com.company.employees;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Employees {
    private final ArrayList<Employee> employees;
    public int curId = 1;

    public Employees(ArrayList<Employee> employees) {
        this.employees = employees;
        while (curId <= employees.size()) {
            this.employees.get(curId - 1).setId(curId++);
        }
    }

    public Employees() {
        this.employees = new ArrayList<>();
    }

    private int orderBySalaryOrName(Employee o1, Employee o2) {
        int res;
        res = Double.compare(o2.getAverageMonthlySalary(), o1.getAverageMonthlySalary());

        if (res == 0) {
            res = o1.getLastName().compareTo(o2.getLastName());
        }

        return res;
    }

    public Employee add(Employee employee) {
        employee.setId(curId++);
        employees.add(employee);
        return employee;
    }

    public ArrayList<Employee> getEmployees() {
        return employees.stream().sorted(this::orderBySalaryOrName).collect(Collectors.toCollection(ArrayList::new));
    }
}
