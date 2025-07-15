package org.example.demo;

public class BasicThreadConcept implements Runnable{

    @Override
    public void run() {


        System.out.println(            "Thread is running: " + Thread.currentThread().getName() + " - " + Thread.currentThread().getId()
        );

    }
}
