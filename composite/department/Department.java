package org.example.gofpatterns.composite.department;

public abstract class Department {
    private int employeesQuantity;

    public Department(int employeesQuantity) {
        this.employeesQuantity = employeesQuantity;
    }

    public abstract void printDepartmentName();

    public int getEmployeesQuantity() {
        return employeesQuantity;
    }
}
