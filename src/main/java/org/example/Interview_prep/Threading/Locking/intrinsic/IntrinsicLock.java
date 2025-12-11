package org.example.Interview_prep.Threading.Locking.intrinsic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class IntrinsicLock {
    static Integer data=0;
   static volatile Integer count = 0;
   static AtomicInteger res=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool=Executors.newFixedThreadPool(10);

        for(int i=0;i<1000;i++){
            threadPool.execute(()->{
                updateData();
            });
        }
        Thread.sleep(10000);
        System.out.println("data is"+ data+" "+ count+"+count " +"atomic "+res);
        threadPool.shutdown();

    }


    public static synchronized void updateData(){
        data++;
      //  count++;
        //res.incrementAndGet();

    }
}
