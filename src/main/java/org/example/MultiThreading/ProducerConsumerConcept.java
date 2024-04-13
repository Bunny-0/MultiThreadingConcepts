package org.example.MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;


class ProducerBlockingQueue implements Runnable{

    private  BlockingQueue<Integer> queue;

    public ProducerBlockingQueue(BlockingQueue<Integer> queue){
        this.queue=queue;
    }

    @Override
    public void run() {

        try{
            for(int i=0;i<100;i++){
                Thread.sleep(1000);
                queue.put(i);
                System.out.println("Produced: "+i);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
class ConsumerBlockingQueue implements Runnable{

    private  BlockingQueue<Integer> queue;

    public ConsumerBlockingQueue(BlockingQueue<Integer> queue){
        this.queue=queue;
    }

    @Override
    public void run() {

        try{
            while(true){
                Integer item=queue.take();
                System.out.println("Consumed: "+item);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }
}

public class ProducerConsumerConcept {

    public static void main(String args[]){

        BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(5);
        ProducerBlockingQueue producer=new ProducerBlockingQueue(queue);
        ConsumerBlockingQueue consumer=new ConsumerBlockingQueue(queue);

        Thread producerThread =new Thread(producer);
        Thread consumerThread =new Thread(consumer);
        producerThread.start();
        consumerThread.start();


    }
}
