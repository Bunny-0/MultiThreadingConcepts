package org.example.Revision;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {

    Lock lock =new ReentrantLock();
    int avlAmount=2000;


    public void withDrawMoney(int amount) throws InterruptedException {
        System.out.println("Thread " + Thread.currentThread().getName() + " is trying to withdraw " + amount + " from the account.");

//        if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
            System.out.println("Thread " + Thread.currentThread().getName() + " has acquired the lock");

            if(avlAmount>=amount){

                avlAmount-=amount;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    System.out.println("Withdrawing done by " + Thread.currentThread().getName() + " and balance now is " + avlAmount);
//                    lock.unlock();
                }
            }

        }

//    }



    public static void main(String[] args) throws InterruptedException {

        Locking locking = new Locking();

        Thread th1=new Thread(()->{
            try {
                locking.withDrawMoney(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread th2=new Thread(()->{
            try {
                locking.withDrawMoney(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        th1.start();
        th2.start();

    }
}
