package org.example.Revision.OOP;

public interface EmployeeService {

    void promoteEmployee(int employeeId, double increment);
    void transferEmployee(int employeeId, String newDepartment);
    double calculateAnnualBonus(int employeeId);
    void displayEmployeeDetails(int employeeId);

    default void logAction(String action){
        System.out.println("Action Logged: " + action);
    }
    static boolean workingHours(int hour){
        return hour>=10 && hour<=16;
    }
}
