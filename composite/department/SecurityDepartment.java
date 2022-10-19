package org.example.gofpatterns.composite.department;

public class SecurityDepartment extends Department{

    public SecurityDepartment(int employeesQuantity) {
        super(employeesQuantity);
    }

    @Override
    public void printDepartmentName() {
        System.out.println(this.getClass().getSimpleName());
    }
}
