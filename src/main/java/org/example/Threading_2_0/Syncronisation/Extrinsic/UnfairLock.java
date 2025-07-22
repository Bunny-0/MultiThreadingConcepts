package org.example.Threading_2_0.Syncronisation.Extrinsic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class UnfairLock {


    Lock lock = new ReentrantLock(false);
    public void consumeResource() throws InterruptedException {
        lock.lock();
        try {


            System.out.println("Thread " + Thread.currentThread().getName() + " has acquired the lock and is consuming the resource.");
            Thread.sleep(1000);
        } catch (Exception e) {

        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " is releasing the lock.");
            lock.unlock();
        }
    }

    public static void main(String args[]) {

        UnfairLock unfairLock = new UnfairLock();
        Thread th1 = new Thread(() -> {

            try {
                unfairLock.consumeResource();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Consumer-Thread-1");
        Thread th2 = new Thread(() -> {

            try {
                unfairLock.consumeResource();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Consumer-Thread-2");
        Thread th3 = new Thread(() -> {

            try {
                unfairLock.consumeResource();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Consumer-Thread-3");
        th1.start();
        th2.start();
        th3.start();

    }
}
