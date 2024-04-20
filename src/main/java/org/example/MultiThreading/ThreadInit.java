package org.example.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

class counterCheck{

    private int count;

    public void increment(){
        synchronized (this.getClass()) {
            this.count++;
        }
    }
    public int getCount(){
        return this.count;
    }

//AtomicInteger count=new AtomicInteger(0);
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


public class ThreadInit {



    public static void main(String args[]){
        counterCheck counter=new counterCheck();

        Thread th1=new Thread(()->{
            System.out.println("Hi Threads Started");
            for(int i=0;i<50000;i++){
                counter.increment();

            }
            System.out.println("Hi Threads completed");

        });

        Thread th2=new Thread(()->{
            System.out.println("Hi th2 Threads Started");
            for(int i=0;i<50000;i++){
                counter.increment();

            }
            System.out.println("Hi th2 completed");
            System.out.println("count is "+counter.getCount());
            System.out.println(Thread.currentThread().getName());
        });

        th1.start();
        th2.start();

    }



}
