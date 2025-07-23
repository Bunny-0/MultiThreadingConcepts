package org.example.Threading_2_0.Executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {



    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> future= executorService.submit(()->{
            Thread.sleep(2000);
            return 9;
        });
// get()->Timeout
//        try{
//            Integer i= future.get(1, TimeUnit.SECONDS);
//        }catch (Exception e){
//            System.out.println("Exception occurred: " + e.getMessage());
//        }

        while (future.isDone() == false) {
            System.out.println("Waiting for the future to complete...");
            Thread.sleep(1000);
        }
        executorService.shutdown();
        System.out.println(
                "Future result: " + future.isDone() + " " + future.isCancelled() + " " + future.get()
        );




    }
}
