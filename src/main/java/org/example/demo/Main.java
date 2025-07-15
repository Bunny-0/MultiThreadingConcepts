package org.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String args[]) throws InterruptedException {

//        Thread th1=new Thread(new BasicThreadConcept());
//        th1.start();
//
//        Thread th2=new Thread(new BasicThreadConcept());
//        th2.start();


//        Thread th1=new Thread(()->{
//
//            System.out.println("Thread1 Started");
//            for(int i=0;i<10;i++){
//                System.out.println("Thread1 is running: " + Thread.currentThread().getName() + " - " + Thread.currentThread().getId());
//                //Thread.yield();
//            }
//        });
//
//        Thread th2=new Thread(()->{
//
//            System.out.println("Thread2 Started");
//            for(int i=0;i<10;i++){
//                System.out.println("Thread2 is running: " + Thread.currentThread().getName() + " - " + Thread.currentThread().getId());
//
//
//
//            }
//
//        });
//        th1.run();
//        th1.start();
//        th2.start();
//        th1.join();

         AtomicInteger i= new AtomicInteger();

        Thread th1=new Thread(()->{

            System.out.println("Thread1 Started");
            for(int j=0;j<10;j++){
                System.out.println("Thread1 is running: " + Thread.currentThread().getName() + " - " + Thread.currentThread().getId());
                i.getAndIncrement();

            }
            System.out.println("Thread1 completed with i = " + i);
        });
        Thread th2 =new Thread(()->{
            System.out.println("Thread2 Started");
            for(int j=0;j<10;j++){
                System.out.println("Thread2 is running: " + Thread.currentThread().getName() + " - " + Thread.currentThread().getId());
                i.getAndIncrement();
            }
            System.out.println("Thread2 completed with i = " + i);
        });

        th1.start();
        th2.start();
        th1.join();
        th2.join();

    }
}
