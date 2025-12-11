package org.example.Interview_prep;

public class Single {

    private Single obj=null;

    private Single(){

    }

    public Object GetObj(){

        if(obj==null){

            synchronized (Single.class){
                obj=new Single();

            }
        }
        return obj;
    }
}
