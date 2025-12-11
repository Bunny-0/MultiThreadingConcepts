package org.example.Interview_prep.Threading.Executor;

import java.util.concurrent.*;

import static java.awt.desktop.UserSessionEvent.Reason.LOCK;

public class Completable_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService cahce= Executors.newCachedThreadPool();
        CountDownLatch latch=new CountDownLatch(3);

//        for(int i=0;i<100;i++){
//
//
//            cahce.execute(()->{
//
//                try {
//                    Thread.sleep(300);
//                    System.out.println("Thread is "+Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            });
//        }
//        for(int i=0;i<100;i++){
//
//
//            cahce.execute(()->{
//                synchronized (LOCK) {
//                    try {
//                        LOCK.wait(300);
//                        System.out.println("Thread is "+Thread.currentThread().getName());
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//
//            });
//        }
//        cahce.shutdown();

        //if dont want to return anything

        CompletableFuture.runAsync(()->{

            try {
                Thread.sleep(300);
                System.out.println("current thread is "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //u dont want get any o/p bec the main thread dont take res odf completable future and stopped

        CompletableFuture<Boolean> futureRes=CompletableFuture.supplyAsync(()->{

            try {
                Thread.sleep(300);
                System.out.println("Return future "+Thread.currentThread().getName());
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },cahce);
//        System.out.println(futureRes.get());

        Integer tax=10;

        CompletableFuture<String> accountData=CompletableFuture.supplyAsync(()->{

            try {
                Thread.sleep(300);
                System.out.println("Return future for account data By "+Thread.currentThread().getName());
                latch.countDown();
                return "account1";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },cahce);
        CompletableFuture<Void> updateBalance=accountData.thenAccept((account)->{

            Integer amount=getAmount(account);
             amount=amount-tax;
             updateAmount(account,amount);
            latch.countDown();
            System.out.println("balance fetch done by "+Thread.currentThread().getName());

        }).thenRun(()->{
            latch.countDown();
            System.out.println("Done By "+Thread.currentThread().getName());
        });
        latch.await();
        cahce.shutdown();


        System.out.println("status of main thread are "+Thread.currentThread().getState());

    }

    private static void updateAmount(String account, Integer amount) {

    }

    private static int getAmount(String account) {
        return 100;
    }
}
