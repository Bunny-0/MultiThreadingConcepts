package org.example.MultiThreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceConcept {

    public static void main(String args[]) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("single Thread Executor  started: ");
        for(int i=0;i<=5;i++){
            final  int taskId=i;
            singleThreadExecutor.execute(()-> {
                System.out.println("Single thread task" + taskId +" executed by Thread" +Thread.currentThread().getName());

            });

        }
        singleThreadExecutor.shutdown();

        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(3);

        System.out.println("\nFixed Length threadPool Started: ");
        for(int i=0;i<=5;i++){
            int taskid=i;
            fixedThreadPool.execute(()->{
                System.out.println("Fixed thread task" + taskid +" executed by Thread" +Thread.currentThread().getName());
            });
        }
        fixedThreadPool.shutdown();

        ExecutorService cacheThreadPool=Executors.newCachedThreadPool();
        System.out.println("\ncache Length threadPool Started: ");

        for(int i=0;i<=5;i++){
            int taskId=i;
            cacheThreadPool.execute(()->{
                System.out.println("cache thread task" + taskId +" executed by Thread" +Thread.currentThread().getName());
            });
        }
        cacheThreadPool.shutdown();

        ExecutorService scheduledThreadPool=Executors.newScheduledThreadPool(2);
        System.out.println("\nscheduled threadPool Started: ");

        for(int i=0;i<=5;i++){
            int taskId=i;
            cacheThreadPool.execute(()->{
                System.out.println("scheduled thread task" + taskId +" executed by Thread" +Thread.currentThread().getName());
            });
        }
        cacheThreadPool.shutdown();

    }
}
