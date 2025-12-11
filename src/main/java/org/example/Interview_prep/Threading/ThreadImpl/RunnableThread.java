package org.example.Interview_prep.Threading.ThreadImpl;

public class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("inside Runnable "+Thread.currentThread().getName() );
    }
}
