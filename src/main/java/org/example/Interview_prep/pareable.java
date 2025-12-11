package org.example.Interview_prep;

import java.util.*;

public class pareable {

    public static void main(String[] args) {

        List<student> ll=new ArrayList<>();

        Comparator<student> sortByName=(s1,s2)->s1.name.compareTo(s2.name);
        Collections.sort(ll,sortByName);
    }
}


class student implements Comparable<student>{
    String name;
    int age;
    @Override
    public int compareTo(student o) {
        return this.age-o.age;
    }
}
