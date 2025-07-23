package org.example.Threading_2_0.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledExecutorServices {

    public static void main(String args[]){

        ScheduledExecutorService executors=Executors.newScheduledThreadPool(1);

        executors.schedule(()->{
            System.out.println("Task executed after 5 seconds delay");
        }, 5, java.util.concurrent.TimeUnit.SECONDS);
        executors.shutdown();


        ScheduledExecutorService executorsFixedDelay=Executors.newScheduledThreadPool(1);
        executorsFixedDelay.scheduleAtFixedRate(() -> {
            System.out.println("Task executed at fixed rate every 3 seconds");
        }, 0, 3, java.util.concurrent.TimeUnit.SECONDS);


        executorsFixedDelay.schedule(() -> {
            System.out.println("Task executed after 5 seconds delay");
            executorsFixedDelay.shutdown();
        }, 10, java.util.concurrent.TimeUnit.SECONDS);


    }
}
