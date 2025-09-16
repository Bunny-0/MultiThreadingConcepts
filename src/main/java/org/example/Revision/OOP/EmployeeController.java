package org.example.Revision.OOP;

public interface EmployeeController {

    int min=500;


    void addEmployee(Employee employee);
    void removeEmployee(int employeeId);
    Employee getEmployee(int employeeId);
    void updateEmployee(Employee employee);

    default void start(){
        System.out.println("Starting Employee Controller...");
    }
}
