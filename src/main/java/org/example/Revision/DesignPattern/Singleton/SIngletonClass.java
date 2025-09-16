package org.example.Revision.DesignPattern.Singleton;

public enum SIngletonClass {

    INSTANCE;
    int data=0;

    public SIngletonClass getInstance(){
        return INSTANCE;
    }
    public int getData(){
        return data;
    }


}
