package org.example.Revision;

import java.util.concurrent.CountDownLatch;

public class Latcher {
    public static void main(String[] args) throws InterruptedException {
        int numberOfTasks = 3;
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        for (int i = 1; i <= numberOfTasks; i++) {
            int taskId = i;
            new Thread(() -> {
                System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " finished.");
                latch.countDown();  // Decrease count
            }).start();
        }

        System.out.println("Main thread waiting for tasks to finish...");
        latch.await();  // Wait until all tasks complete
        System.out.println("All tasks are finished. Main thread resumes.");
    }
}
