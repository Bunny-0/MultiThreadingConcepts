package org.example.Interview_prep;

import java.util.ArrayList;
import java.util.List;

public class Copy {

    public static void main(String[] args) {

        //ShallowCopy
//
//        List<Integer> ll=new ArrayList<>();
//
//        ll.add(1);
//        List<Integer> ll2=new ArrayList<>();
//        ll2=ll;
//        ll2.add(2);
//        System.out.println(ll.toString() +" "+ll2.toString());

    }
}

class Bird implements Cloneable{


    int x;

    @Override
    protected Bird clone() throws CloneNotSupportedException {
        Bird b= (Bird)super.clone();
        return b;
    }
}
