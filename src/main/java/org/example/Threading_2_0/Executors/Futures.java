package org.example.Threading_2_0.Executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Futures {

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);


        Callable<Integer> callable = () -> {
            Thread.sleep(1000);
            System.out.println("Callable1 is executing");
            return 42;
        };
        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Callable2 is executing");
            return 43;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Callable3 is executing");
            return 44;
        };
        System.out.println("after treads are done executing");

        List<Callable<Integer>> ll= Arrays.asList(callable,callable1,callable2);
        List<Future<Integer>> future=executorService.invokeAll(ll,4, TimeUnit.SECONDS);
        System.out.println(future.toString());
        System.out.println(future.get(0).get());
        System.out.println( executorService.isTerminated() + " and " + executorService.isShutdown());
        System.out.println("after treads are done executing, we can shutdown the executor service");
        executorService.shutdown();
        Thread.sleep(2000);
        System.out.println( executorService.isTerminated() + " and " + executorService.isShutdown());




    }
}
