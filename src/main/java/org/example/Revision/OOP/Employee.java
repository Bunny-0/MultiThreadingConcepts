package org.example.Revision.OOP;

public class Employee implements Cloneable ,Comparable<Employee> {



    int id;
    String name ;
    double salary;
    int age;
    String department;


    public Employee(int id, String name, double salary, int age, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.department = department;
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone(); // shallow copy
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {

        if(o.id==this.id){

            if(o.name.equals(this.name)){

                    return o.age-this.age;
            }else {
                return this.name.compareTo(o.name);
            }
        }else {
            return this.id-o.id;
        }
    }
//
//    @Override
//    public int hashCode() {
//        return Integer.hashCode(id);
//
//    }



}
