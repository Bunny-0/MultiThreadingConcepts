package org.example.Revision.OOP;

public class Single
{


    private volatile static Single instance = null;

    private Single(){

    }

    public Single getObj(){
        synchronized (Single.class){
            if(instance==null){
                instance=new Single();

            }
        }

        return instance;
    }
}
