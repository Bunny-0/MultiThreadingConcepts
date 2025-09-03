package org.example.Revision_2;

public class ProducerConsumer {


    boolean hasData=false;
    int data;

    public synchronized void produce(int value) throws InterruptedException {

        while(hasData){
            wait();
        }
        data=value;
        System.out.println("Data is produced "+data);
       hasData=true;
      notify();


    }


    public synchronized void consume() throws InterruptedException {

        while(!hasData){
            wait();
        }
        System.out.println("Data is consumed "+data);
        hasData=false;
        notify();

    }
}
