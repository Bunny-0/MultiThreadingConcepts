package org.example.Threading_2_0.Syncronisation.Intrinsic;

public class Counter {

    int counter=0;

    public  void increment(){
        synchronized (this){
            counter++;
        }
    }
    public int getCount(){
        return counter;
    }

}
