package org.example.Interview_prep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Counters {


    static AtomicInteger atomicInteger=new AtomicInteger(0);

public static void main(String args[]) throws InterruptedException {

    ExecutorService executorService=Executors.newFixedThreadPool(10);

    for(int i=0;i<1000;i++){
        executorService.submit(()->atomicInteger.incrementAndGet());
    }

    executorService.shutdown();
    executorService.awaitTermination(5, TimeUnit.SECONDS);
    System.out.println("final value is "+atomicInteger.get());
}

}
