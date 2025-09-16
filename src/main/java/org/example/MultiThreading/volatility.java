package org.example.MultiThreading;

public class volatility {

    private volatile boolean running = true; // flag

    public void runTask() {
        System.out.println("Task started...");
        while (running) {

        }
        System.out.println("Task stopped.");
    }

    public void stopTask() {
        running = false;
    }
}

 class Main {
    public static void main(String[] args) throws InterruptedException {
        volatility demo = new volatility();

        Thread t1 = new Thread(demo::runTask);
        t1.start();

        Thread.sleep(2000);
        demo.stopTask();
    }
}
