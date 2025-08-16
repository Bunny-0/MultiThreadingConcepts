package org.example.Revision;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterService {


    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskId + " by " + Thread.currentThread().getName());
                try { Thread.sleep(2000); } catch (InterruptedException e) {}
            });
        }

        executor.shutdown();

    }
}
