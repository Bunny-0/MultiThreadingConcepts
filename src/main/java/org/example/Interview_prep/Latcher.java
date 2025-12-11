package org.example.Interview_prep;

import java.util.concurrent.*;

public class Latcher {




    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    static CountDownLatch latch=new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Future<String> future1 = executorService.submit(() -> {
            try {
                Thread.currentThread().sleep(5000);
                return "data1";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "error"; // or null or default value
            } finally {
                latch.countDown();
            }
        });

        Future<String> future2 = executorService.submit(() -> {
            try {
                Thread.currentThread().sleep(5000);
                return "data2";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "error";
            } finally {
                latch.countDown();
            }
        });


        Future<String> future3 = executorService.submit(() -> {
            try {
                Thread.currentThread().sleep(50000);
                return "data3";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "error"; // or null or default value
            } finally {
                latch.countDown();
            }
        });



        latch.await();
        System.out.println("Data is"+future1.get() +" "+future2.get()+" "+future3.get());
        executorService.shutdown();
    }


}
