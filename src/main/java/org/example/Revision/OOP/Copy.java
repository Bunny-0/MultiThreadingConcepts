package org.example.Revision.OOP;

public class Copy   {

    int id;
    String data;
    public Copy(int id, String data){
        this.id=id;
        this.data=data;
    }


    public Copy clone()   {
        return this;
    }

    @Override
    public String toString() {
        return "Copy{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }

    public static void main(String args[]) throws CloneNotSupportedException {

        Copy c1=new Copy(1,"shubham");

        Copy hardCopy=new Copy(c1.id,c1.data);

        hardCopy.data="kumar";

        System.out.println(c1.toString());
        System.out.println(hardCopy.toString());

        System.out.println(" now shallow copy");

        Copy shallowCopy=c1.clone();
        shallowCopy.data="verma";
        System.out.println(c1.toString());
        System.out.println(shallowCopy.toString());
        System.out.println(c1.hashCode()+" "+shallowCopy.hashCode());
    }
}
