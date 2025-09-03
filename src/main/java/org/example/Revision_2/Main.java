package org.example.Revision_2;

import static java.lang.Thread.sleep;

public class Main {


    public static void main(String args[]) throws InterruptedException {


        Thread th1=new Thread(()->{
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1 is running");
        });

        Thread th2=new Thread(()->{
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 is running");
        });
        th1.start();
        th1.join();
        th2.start();

        ProducerConsumer producerConsumer=new ProducerConsumer();
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    producerConsumer.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });
        producer.start();
        consumer.start();


    }
}
