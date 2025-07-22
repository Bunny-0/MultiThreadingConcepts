package org.example.Threading_2_0.Syncronisation.Extrinsic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {

    int count = 0;

    ReadWriteLock lock = new ReentrantReadWriteLock();

    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();


    public void increment() {

        writeLock.lock();
        try {
            count++;
        } catch (Exception e) {

            System.out.println("Exception occurred while incrementing: " + e.getMessage());
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() throws InterruptedException {
        readLock.lock();
        Thread.sleep(1000); // Simulating some delay to show the effect of read lock
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String args[]) {

        ReadWriteLocks readWriteLocks = new ReadWriteLocks();

        Thread writeThread = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                readWriteLocks.increment();
                try {
                    System.out.println("Read by Thread 2: " +Thread.currentThread().getName() +" "+ readWriteLocks.getCount());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "writeThread");
        Thread writeThread1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                readWriteLocks.increment();
                try {
                    System.out.println("Read by Thread 2: " +Thread.currentThread().getName() +" "+ readWriteLocks.getCount());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "writeThread1");
        Thread readThread = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Read by Thread 2: " +Thread.currentThread().getName() +" "+ readWriteLocks.getCount());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }, "readThread");

        Thread readThread2 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Read by Thread 2: " +Thread.currentThread().getName() +" "+ readWriteLocks.getCount());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "readThread2");

        writeThread.start();
        writeThread1.start();
//        readThread.start();
//        readThread2.start();
        try {
            writeThread.join();
            writeThread1.join();
//            readThread.join();
//            readThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Exception occurred while joining threads: " + e.getMessage());
        }
    }
}
