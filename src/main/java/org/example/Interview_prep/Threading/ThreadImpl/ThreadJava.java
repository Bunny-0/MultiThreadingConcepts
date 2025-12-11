package org.example.Interview_prep.Threading.ThreadImpl;

import java.util.concurrent.*;

public class ThreadJava {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread th1=new Thread(()->{
            System.out.println("Hi "+Thread.currentThread().getName());
        },"thread1");
        th1.start();
//        th1.run();
        System.out.println("this is outside "+Thread.currentThread().getName());
        RunnableThread runnableThread=new RunnableThread();
        //Thread th2=new Thread(runnableThread);
        CallableThread callableThread=new CallableThread();
        FutureTask<String> futureTask=new FutureTask<>(callableThread);
        Thread th3=new Thread(futureTask);
        th3.start();
     //   th2.start();

        ExecutorService threadPool=Executors.newFixedThreadPool(5);

        threadPool.execute(runnableThread);

        Future<String> future=threadPool.submit(callableThread);
        System.out.println(future.get());
        System.out.println("Current thread is "+ Thread.currentThread().getName()+" nd state is "+Thread.currentThread().getState());


    }
}
