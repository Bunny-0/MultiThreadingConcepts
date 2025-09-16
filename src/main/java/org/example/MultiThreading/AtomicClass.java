package org.example.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClass {

    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet(); // atomic increment
    }

    public int get() {
        return counter.get();
    }
}
 class Mains {
    public static void main(String[] args) throws InterruptedException {
        AtomicClass c = new AtomicClass();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
       t1.join();
       t2.join();

        System.out.println("Final counter = " + c.get()); // 2000 ✅ correct
    }
}
