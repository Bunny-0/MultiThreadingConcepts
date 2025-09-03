package org.example.Revision.Hashing;

import java.util.HashMap;
import java.util.Map;

public class Calling {

    public static void main(String[] args) {

        User u1 = new User(1, "A");
        User u2 = new User(1, "A");

        Map<User,Object> mp=new HashMap<>();
        mp.put(u1,new Object());
        mp.put(u2,new Object());
        System.out.println(mp.size());


        System.out.println(u1.hashCode() +" "+u2.hashCode());
    }
}
