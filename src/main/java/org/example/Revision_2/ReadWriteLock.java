package org.example.Revision_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    static  ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);
    static Lock readLock = rwLock.readLock();
    static Lock writeLock = rwLock.writeLock();
    static int data = 0;
    public static  void writeData(int val){
        writeLock.lock();
        System.out.println("Writing data "+val);
        data=val;
        writeLock.unlock();


    }


    public static void readData(){

        readLock.lock();
        System.out.println("Reading data "+data);
        readLock.unlock();
    }

    public static void main(String args[]){

        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                writeData(i);
            }
        }, "Writer");

        Thread reader1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) readData();
        }, "Reader-1");

        Thread reader2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) readData();
        }, "Reader-2");

        writer.start();
        reader1.start();
        reader2.start();
    }


}
