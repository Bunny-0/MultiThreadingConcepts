package org.example.Threading_2_0.Executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureClass {

    public static void main(String args[]) throws InterruptedException, ExecutionException {


        // CompletableFuture is a class that represents a future result of an asynchronous computation.
        // It allows you to write non-blocking code and handle the result of the computation when it is available.
        //deamon thread
//        CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(()->{
//
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("CompletableFuture is executing");
//            return "ok";
//
//        });
//        String data=null;
//        String data1=null;
//        try
//        {
//            data = completableFuture.get(); // This will block until the CompletableFuture is complete
//            data1 = completableFuture.getNow("NO");
//            System.out.println("Data received: " + data );
//            System.out.println("Data received: " + data1 );
//        } catch (Exception e) {
//            System.out.println("Exception occurred: " + e.getMessage());
//        }
//
//
//        System.out.println("Waiting for CompletableFuture to complete...");


//        CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(()->{
//
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("CompletableFuture is executing");
//            return "ok";
//
//        });
//        CompletableFuture<String> completableFuture1=CompletableFuture.supplyAsync(()->{
//
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("CompletableFuture1 is executing");
//            return "oky";
//
//        });
//        CompletableFuture<Void> cf=CompletableFuture.allOf(completableFuture, completableFuture1);
//        cf.join(); // This will block until all CompletableFuture instances are complete
//        System.out.println("All CompletableFuture instances are complete");





        String data=CompletableFuture.supplyAsync(()->{

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("CompletableFuture is executing");
            return "ok";

        }).thenApply(s-> s+" done").get();
        System.out.println("Data received: " + data);
        System.out.println(" CompletableFuture  complete...");

    }
}
