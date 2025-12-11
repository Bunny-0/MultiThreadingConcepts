package org.example.Interview_prep.Threading.Locking.Extrinsic;

import org.example.Revision_2.ReadWriteLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RetLock {

    static Lock lock=new ReentrantLock();

    static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    static Lock readLock=readWriteLock.readLock();
    static Lock writeLock=readWriteLock.writeLock();

    static int data=0;

    public static void main(String[] args) throws InterruptedException {


        ExecutorService threadPool= Executors.newFixedThreadPool(5);

        for(int i=0;i<10000;i++){

            threadPool.execute(()->{

                updateValue();

            });
        }
        Thread.sleep(1000);
        System.out.println("data is "+data);
        threadPool.shutdown();



    }

    private static void updateValue() {
     //   lock.lock();
      //  writeLock.lock();
        readLock.lock();
      try{
          data++;
      }finally {
        //  lock.unlock();
       //   writeLock.unlock();
          readLock.unlock();
      }



    }
}
