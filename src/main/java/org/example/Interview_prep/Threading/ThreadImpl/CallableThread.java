package org.example.Interview_prep.Threading.ThreadImpl;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
     System.out.println("Inside callable thread "+Thread.currentThread().getName());
     Thread.sleep(400);
     return "done";
    }
}
