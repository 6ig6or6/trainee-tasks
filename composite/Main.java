package org.example.gofpatterns.composite;

import org.example.gofpatterns.composite.department.FinancialDepartment;
import org.example.gofpatterns.composite.department.HeadDepartment;
import org.example.gofpatterns.composite.department.SecurityDepartment;

public class Main {
    public static void main(String[] args) {
        FinancialDepartment financialDepartment = new FinancialDepartment(100);
        SecurityDepartment securityDepartment = new SecurityDepartment(300);
        HeadDepartment headDepartment = new HeadDepartment(20,"Main department");
        headDepartment.addDepartment(financialDepartment);
        headDepartment.addDepartment(securityDepartment);

        headDepartment.printDepartmentName();
        System.out.println("All personnel count is " + headDepartment.countAllPersonnel());

    }
}
