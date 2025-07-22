package org.example.Threading_2_0;

import static java.lang.Thread.sleep;

public class ThreadingMain {


    public static void main(String args[]) throws InterruptedException {
        Thread th1=new Thread(()->{

            try {
                sleep(1000);// Simulating some work with sleep
                System.out.println("inside Thread1 Started");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread th2=new Thread(() -> {
            System.out.println("inside Thread2 Started");

        });

        th1.start();
      //th1.join(); // Wait for th1 to finish before starting th2
        th2.start();
    }


}
