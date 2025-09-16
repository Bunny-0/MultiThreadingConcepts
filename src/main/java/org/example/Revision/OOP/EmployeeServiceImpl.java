package org.example.Revision.OOP;

public class EmployeeServiceImpl implements EmployeeService, Worker{
    @Override
    public void promoteEmployee(int employeeId, double increment) {

    }

    @Override
    public void transferEmployee(int employeeId, String newDepartment) {

    }

    @Override
    public double calculateAnnualBonus(int employeeId) {
        return 0;
    }

    @Override
    public void displayEmployeeDetails(int employeeId) {

    }

    @Override
    public void logAction(String action) {
     Worker.super.logAction(action);
    }

    @Override
    public void performDuties() {

    }

    public static void main(String args[]) throws CloneNotSupportedException {
        EmployeeServiceImpl emp=new EmployeeServiceImpl();
        emp.logAction("Promote Employee");
        Employee employee=new Employee(1,"John",50000,30,"IT");
        Employee employee1=employee.clone();
        employee1.id=3;
        employee.name="Alice";
        System.out.println(employee1.name);
        System.out.println(employee.hashCode()+" "+employee1.hashCode());
        System.out.println(employee1.name.hashCode());
        System.out.println(employee.name.hashCode());
        Check e1=Check.INSTANCE;
        Check e2=Check.INSTANCE;
        System.out.println(e1==e2);
    }
}
