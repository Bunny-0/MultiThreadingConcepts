package org.example.Revision;

public class Main {


    public static void main(String args[]) throws InterruptedException {

        Thread th1=new Thread(()->{
            System.out.println("Thread 1 is running");
            try {
               // Thread.yield();
                Thread.sleep(10000);

                System.out.println("Thread 1 is completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread th2=new Thread(()->{
            System.out.println("Thread 2 is running");
        });
        Thread th3=new Thread(()->{
            System.out.println("Thread 3 is running");
        });
//        th1.start();
//        th1.join();
//        th2.start();
//        th1.setPriority(Thread.MIN_PRIORITY
//        );
//        th2.setPriority(Thread.MAX_PRIORITY);
        th1.start();
        th2.start();
        th3.start();

    }
}
