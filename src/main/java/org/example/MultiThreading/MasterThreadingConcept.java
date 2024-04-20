package org.example.MultiThreading;


import java.security.Provider;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

class Counter{
    private int counter;
    public synchronized void increament(){
        counter+=1;
    }

    public int getCount(){
        return counter;
    }
}


class Producer implements Runnable{

    BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> queue){
        this.blockingQueue=queue;
    }


    @Override
    public void run() {

        for(int i=0;i<100;i++){
            try {
                blockingQueue.put(i);
                System.out.println(i+" produced by producer");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}


 class consumer implements Runnable{

    BlockingQueue<Integer> blockingQueue;

    public consumer( BlockingQueue<Integer> queue){
        this.blockingQueue=queue;

    }

     @Override
     public void run() {

        while(true){
            try {
                Thread.sleep(2000);
                Integer get=blockingQueue.take();
                System.out.println("consumed Data "+get);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

     }
 }
public class MasterThreadingConcept {

    public static void main(String args[]){
        //how to create a thread

//        Thread thread1=new Thread(()->{
//
//            System.out.println("thread1 started");
//        });
//
//
//        Thread thread2=new Thread(()->{
//
//            System.out.println("thread2 started");
//        });
//
//        Thread thread3=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("thread 3 started");
//            }
//        });
//
//
//        thread1.start();
//        thread2.start();
//        thread3.start();





        //race Condition




//        Counter count=new Counter();
//
//        Thread thread1=new Thread(()->{
//
//            System.out.println("thread1 started");
//            for(int i=0;i<10000;i++){
//                count.increament();
//            }
//            System.out.println("thread1 stopped");
//        });
//
//
//        Thread thread2=new Thread(()->{
//
//            System.out.println("thread2 started");
//            for(int i=0;i<10000;i++){
//                count.increament();
//            }
//            System.out.println("thread2 stopped");
//        });
//        thread1.start();
//        thread2.start();
//
//        System.out.println("Final Count is " +count.getCount());





        //ExecutorService Implementation in java to control teh concurrency issues.





//        ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();
//
//        for(int i=0;i<=5;i++){
//            final  int taskId=i;
//            singleThreadExecutor.execute(()-> {
//                System.out.println("Single thread task" + taskId +" executed by Thread" +Thread.currentThread().getName());
//
//            });
//
//        }
//
//        ExecutorService fixedThreadexecutor=Executors.newFixedThreadPool(3);
//
//        for(int i=0;i<=5;i++){
//            final  int taskId=i;
//            fixedThreadexecutor.execute(()-> {
//                System.out.println("Fixed thread task" + taskId +" executed by Thread" +Thread.currentThread().getName());
//
//            });
//
//        }
//        ExecutorService cacheThreadexecutor=Executors.newCachedThreadPool();
//
//        for(int i=0;i<=5;i++){
//            final  int taskId=i;
//            fixedThreadexecutor.execute(()-> {
//                System.out.println("DYnamic thread task" + taskId +" executed by Thread" +Thread.currentThread().getName());
//
//            });
//
//        }


        //producer Consumer problems Implementaation


        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(5);;
       Producer producer=new Producer(blockingQueue);
       consumer consumer=new consumer(blockingQueue);

       Thread producerThread=new Thread(producer);
        Thread consumerThread=new Thread(consumer);

        producerThread.start();
        consumerThread.start();







    }
}
