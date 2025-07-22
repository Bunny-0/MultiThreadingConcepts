package org.example.Threading_2_0.Syncronisation.Extrinsic;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Withdraw {

    int balance=10000;

    Lock lock = new ReentrantLock();

    public void withdrawAmount(int amount) throws InterruptedException {

    //incase of synchronised the thread 2 was waiting infinately till thread1 cmplt its exceution
        //now using loc we can customise the lock to wait only for next 1sec if release then fine else start working other independent activit
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                if (balance >= amount) {
                    try {
                        System.out.println("Thread " + Thread.currentThread().getName());
                        Thread.sleep(3000);

                        balance -= amount;
                        System.out.println("Withdrawing done by " + Thread.currentThread().getName() + "and balance now is " + balance);
                    }catch (Exception e){
                        System.out.println("Exception occurred while withdrawing: " + e.getMessage());
                    } finally {
                        lock.unlock();
                    }} else {
                    System.out.println("Insufficient balance to withdraw " + amount + " at " + LocalDateTime.now());
                }
            }else{
                System.out.println("Thread " + Thread.currentThread().getName() + " could not acquire lock, skipping withdrawal ");
            }
        }

    public void withdrawUsingInterruptedAmount(int amount) throws InterruptedException {

        lock.lockInterruptibly();
//        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

            if (balance >= amount) {
                try {
                    System.out.println("Thread " + Thread.currentThread().getName());
                    Thread.sleep(3000);

                    balance -= amount;
                    System.out.println("Withdrawing done by " + Thread.currentThread().getName() + "and balance now is " + balance);
                }catch (Exception e){
                    System.out.println("Exception occurred while withdrawing: " + e.getMessage());
                } finally {
                    lock.unlock();
                }} else {
                System.out.println("Insufficient balance to withdraw " + amount + " at " + LocalDateTime.now());
            }
//        }else{
//            System.out.println("Thread " + Thread.currentThread().getName() + " could not acquire lock, skipping withdrawal ");
//        }
    }

    public int getBalance() {
        return balance;
    }
}
