package org.example.Threading_2_0.Syncronisation.Extrinsic;


class Producer implements Runnable {

    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                resource.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {

    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                resource.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class SharedResource {

    boolean isData;
    int data=0;

    public synchronized void produce(int data) throws InterruptedException {
        while (isData) {

            wait();
        }
        isData=true;
        System.out.println("Produced: " + data);
        this.data= data;
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while (!isData) {
            wait();
        }
        isData=false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }


}
public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
