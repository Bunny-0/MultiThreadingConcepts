package org.example.Interview_prep.Threading.Locking.Communication;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {



    public static void main(String[] args) {

        Resource resource=new Resource();

        Thread th1=new Thread(()->{

            try {
                resource.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread th2=new Thread(()->{
            try {
                resource.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        th1.start();
        th2.start();

    }
}
class Resource{
    static Queue<Integer> queue = new LinkedList<>();
    static int i = 0;

    public synchronized void produce() throws InterruptedException {
        while (true) {
            while (queue.size() == 5) {
                Thread.currentThread().wait();
            }
            queue.add(i);
            i++;
            notify();

        }
    }

    public synchronized void consume() throws InterruptedException {
        while (true) {
            while (queue.isEmpty()) {
                Thread.currentThread().wait();
            }
            int data = queue.poll();
            System.out.println("consumed data is " + data);
            i++;
            notify();
        }

    }



}



