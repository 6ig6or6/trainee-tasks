package org.example.gofpatterns.composite.department;

public class FinancialDepartment extends Department{

    public FinancialDepartment(int employeesQuantity) {
        super(employeesQuantity);
    }

    @Override
    public void printDepartmentName() {
        System.out.println(this.getClass().getSimpleName());
    }
}
