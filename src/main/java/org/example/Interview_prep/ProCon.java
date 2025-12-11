package org.example.Interview_prep;

import java.util.LinkedList;
import java.util.Queue;

public class ProCon {



    public static void main(String[] args){

        sharedResource obj=new sharedResource();
        Thread th1=new Thread(()->{
            try {
                obj.produceData();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread th2=new Thread(()->{
            try {
                obj.consumeData();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        th1.start();
        th2.start();
    }
}

class sharedResource{

    Queue<Integer> queue=new LinkedList<>();
    int capacity=5;
    int data=0;


    public synchronized  void produceData() throws InterruptedException {

        while(true){
        while(queue.size()==capacity){
            wait();
        }
        queue.add(data);
        System.out.println("produced : "+data);
        data++;
        notify();

    }}

    public synchronized void consumeData() throws InterruptedException {
        while (true) {
            while (queue.isEmpty()) {
                wait();
            }
            int res = queue.poll();
            System.out.println("consumed : " + res);
            notify();
        }
    }
}
