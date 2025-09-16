package org.example.Revision.OOP;

public class EmployeeControllerImpl implements EmployeeController{
    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void removeEmployee(int employeeId) {

    }

    @Override
    public Employee getEmployee(int employeeId) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    public static void main(String args[]){

        EmployeeControllerImpl emp=new EmployeeControllerImpl();

        System.out.println(EmployeeController.min);
        emp.start();
        System.out.println(EmployeeService.workingHours(7));
        System.out.println(Worker.workingHours(11));
    }
}
