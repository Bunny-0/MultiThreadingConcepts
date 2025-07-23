package org.example.Threading_2_0.Executors;

import java.util.concurrent.*;

public class CountDownLatcherService {


    public static void main(String args[]) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CountDownLatch latch = new CountDownLatch(3);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        //will wait until completion of all the threads
        latch.await(2000, TimeUnit.MILLISECONDS);
        System.out.println("Main");
        executorService.shutdown();
        //we cant reuse the latch after it has been counted down

    }
}

class DependentService implements Callable<String> {
    private final CountDownLatch latch;
    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started.");
            Thread.sleep(6000);
        } finally {
            latch.countDown();  //shutDown Latch
        }
        return "ok";
    }
}
