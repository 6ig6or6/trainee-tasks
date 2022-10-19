package org.example.gofpatterns.composite.department;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment extends Department {
    private String uniqueName;
    private List<Department> controlledDepartments;

    public HeadDepartment(int employeesQuantity, String uniqueName) {
        super(employeesQuantity);
        this.uniqueName = uniqueName;
        this.controlledDepartments = new ArrayList<>();
    }

    @Override
    public void printDepartmentName() {
        System.out.println("This department name is " + this.uniqueName);
        System.out.println("Child departments: ");
        controlledDepartments.forEach(d -> System.out.println(d.getClass().getSimpleName()));
    }

    public void addDepartment(Department department) {
        controlledDepartments.add(department);
    }

    public void removeDepartment(Department department) {
        controlledDepartments.remove(department);
    }

    public long countAllPersonnel() {
        return controlledDepartments.stream()
                .mapToInt(Department::getEmployeesQuantity)
                .reduce(Integer::sum).orElse(0) + this.getEmployeesQuantity();
    }

}
