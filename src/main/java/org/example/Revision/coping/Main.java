package org.example.Revision.coping;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
       Person person1=new Person(1,"A","xyz");

       Person copy1 =(Person) person1.clone();
       copy1.rollNo=8;

         Person copy2 =(Person) person1.copy();
         System.out.println(copy1.hashCode() +" "+ person1.rollNo);
         System.out.println(copy2.hashCode());
         System.out.println(person1.hashCode());
    }
}
