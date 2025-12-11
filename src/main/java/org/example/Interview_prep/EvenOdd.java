package org.example.Interview_prep;
//: Printing Even and Odd Numbers with Two Threads
public class EvenOdd {

    public static void main(String args[]){
        print obj=new print();
        Thread th1=new Thread(()->{
            try {
                obj.printOdd();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread th2=new Thread(()->{
            obj.printEven();
        });
        th1.start();
        th2.start();
    }



}


class print{

    volatile int index=0;


    public  void printOdd() throws InterruptedException {


        while(index%2==0){
            wait();

        }
        System.out.println(index);
        index++;
        notify();
    }


    public  void printEven(){



    }

}
