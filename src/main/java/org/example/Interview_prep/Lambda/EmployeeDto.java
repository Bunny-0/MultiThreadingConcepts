package org.example.Interview_prep.Lambda;

import java.util.*;
import java.util.stream.Collectors;



public class EmployeeDto {

private String name;
private String department;
private int age;
private String gender;

public EmployeeDto(String name, String department, int age, String gender) {
    this.name = name;
    this.department = department;
    this.age = age;
    this.gender = gender;
}

// Getters
public String getName() {
    return name;
}

public String getDepartment() {
    return department;
}

public int getAge() {
    return age;
}

public String getGender() {
    return gender;
}

// For printing the employee details
@Override
public String toString() {
    return "EmployeeDto{" +
            "name='" + name + '\'' +
            ", department='" + department + '\'' +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            '}';
}

    public static void main(String[] args) {

        EmployeeDto employee2 = new EmployeeDto("Salman","CS",44,"Male");
        EmployeeDto employee3 = new EmployeeDto("Katrina","ECE",21,"Female");
        EmployeeDto employee4 = new EmployeeDto("Kareena","CS",34,"Female");
        EmployeeDto employee5 = new EmployeeDto("Hrithik","EEE",30,"Male");
        EmployeeDto employee6 = new EmployeeDto("Aish","EEE",25,"Female");
        List<EmployeeDto> employeeDtoList=new ArrayList<>();
        employeeDtoList.add(employee2);
        employeeDtoList.add(employee3);
        employeeDtoList.add(employee4);
        employeeDtoList.add(employee5);
        employeeDtoList.add(employee6);

        //1.Find the names of all Employees in the CS department, sorted by age in descending order
        List<String> data= Collections.singletonList(employeeDtoList.stream().filter(e -> e.department.equals("CS")).sorted((a, b) -> Integer.compare(a.getAge(), b.getAge())).map(EmployeeDto::getName).collect(Collectors.joining(" ")));

        System.out.println(data);
        //2. Group Employees by department and count how many Employees are in each department
        Map<String, Long> result=employeeDtoList.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment, Collectors.counting()));
        //.Find the youngest female Employee.
//        1.Find the names of all Employees in the CS department, sorted by age in descending order
//        2. Group Employees by department and count how many Employees are in each department
//        3.Find the youngest female Employee.
//        4. Create a map of department -> list of Employee names.

        Map<String, List<String>> result1 = employeeDtoList.stream()
                .collect(Collectors.groupingBy(
                        EmployeeDto::getDepartment,
                        Collectors.mapping(EmployeeDto::getName, Collectors.toList())
                ));

//        5. Find the average age of Employees in each department.

        Double avg=employeeDtoList.stream().mapToInt(e->e.getAge()).average().getAsDouble();

//        6. Get a list of unique departments Employees belong to
       // employeeDtoList.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment),Collectors.counting().equals(1));
//        7. Partition Employees into male and female groups, then list their names.
    //    employeeDtoList.stream().collect(Collectors.groupingBy(EmployeeDto::getGender),Collectors.mapping(EmployeeDto::getGender),Collectors.toList());//        8. Group employees by department, then within each department find the oldest employee
//        9. Build a map of gender with average age of employees sorted by average age descending
//        10. For each department, find the youngest employee, but instead of returning the employee object,
//        return only their name in uppercase.
//        11. Return a map where keys will be first letter of the name and value will the set of names starting with
//        that letter, no solution provided, try on your own.
//                Code link:  StreamsScenarios/StreamsOnEmployeeData.java at main · Co

    }
}