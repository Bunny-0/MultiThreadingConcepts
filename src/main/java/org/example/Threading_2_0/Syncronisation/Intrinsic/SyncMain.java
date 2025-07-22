package org.example.Threading_2_0.Syncronisation.Intrinsic;

public class SyncMain {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        MyThread th1 = new MyThread(counter);
        MyThread th2 = new MyThread(counter);
        th1.start();
        th2.start();
        //without join the main thread wont wait for the 2 threads to cmplt
        th1.join();
        th2.join();

        System.out.println("count: " + counter.getCount());
    }
}
