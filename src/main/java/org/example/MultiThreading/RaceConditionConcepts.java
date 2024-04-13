package org.example.MultiThreading;


import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter{


//    int count;
//
//    public int getcount(){
//        return count;
//    }
//    public  void increment(){
//        this.count++;
//    }
//    public void decrement(){
//        this.count--;
//    }

        int count;

    public int getcount(){
        return count;
    }
    public synchronized void increment(){
        this.count++;
    }
    public void decrement(){
        this.count--;
    }


//    AtomicInteger count=new AtomicInteger(0);
//
//    public int getcount(){
//        return count.get();
//    }
//    public  void increment(){
//        count.incrementAndGet();
//    }
//    public void decrement(){
//        count.decrementAndGet();
//    }
}

public class RaceConditionConcepts {


    public static void main(String args[])
    {
        SharedCounter counter=new SharedCounter();

        new Thread(()->{
            System.out.println("Thread1 Started");
                for (int i = 0; i < 5000; i++) {
                    counter.increment();
                }
                System.out.println("Thread1 stopped");
        }).start();

        new Thread(()->{
            System.out.println("Thread2 Started");
            for (int i = 0; i < 5000; i++) {
                counter.increment();
            }
            System.out.println("Thread2 stopped");
        }).start();



        System.out.println("counter is "+counter.getcount());


    }
};
