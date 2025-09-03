package org.example.Revision_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class locking {


    static Lock lock=new ReentrantLock(true);

    static int data=0;
    public static void increment(){
        lock.lock();
        for(int i=0;i<50000;i++){
            data++;
        }
        lock.unlock();

    }

    public static  void decrement(){
        lock.lock();
        for(int i=0;i<50000;i++){
            data--;
        }
        lock.unlock();

    }



    public static void main(String[] args) throws InterruptedException {


     Thread th1=new Thread(()->{
         increment();
     });
     Thread th2=new Thread(()->{
         decrement();
     });
     th1.start();
     th2.start();

     sleep(50000);
     System.out.println(data);




    }
}
