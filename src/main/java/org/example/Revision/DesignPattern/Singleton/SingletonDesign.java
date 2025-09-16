package org.example.Revision.DesignPattern.Singleton;

public class SingletonDesign {




    SingletonDesign obj=null;

    private SingletonDesign(){

    }

    public SingletonDesign getInstance(){



        if(obj==null){
            synchronized (SingletonDesign.class)
            {
                if(obj==null)
                {
                    obj=new SingletonDesign();
                }
            }
        }

            return obj;

    }
    }



