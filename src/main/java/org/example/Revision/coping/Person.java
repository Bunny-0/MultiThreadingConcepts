package org.example.Revision.coping;

public class Person implements Cloneable{



    int rollNo;
    String name;
    String address;

    public Person(int rollNo, String name, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
       return super.clone();
    }

    public Object copy(){
        return new Person(this.rollNo,this.name,this.address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
