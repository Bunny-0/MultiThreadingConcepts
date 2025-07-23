package org.example.Threading_2_0.Executors;

import java.util.concurrent.*;

public class ExecutorFrameWork {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
//       ExecutorService executorService= Executors.newFixedThreadPool(3);
       ExecutorService executorService1=Executors.newCachedThreadPool();

       for(int i=1;i<9;i++){
           int finalI = i;

           Future<?> future = executorService1.submit(() -> {
            long data = factorial(finalI);
            System.out.println("Factorial of " + finalI + " is: " + data);
       });

           System.out.println("Total time " + (System.currentTimeMillis() - startTime));

       }
        executorService1.shutdown();

       while(!executorService1.awaitTermination(10, TimeUnit.MILLISECONDS)){
           System.out.println("Waiting for tasks to complete...");
       }



    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}