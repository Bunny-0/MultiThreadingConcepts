package org.example.Revision.Hashing;

public class User {


    int rollNo;
    String name;

    public User(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
   @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return rollNo == user.rollNo && name.equals(user.name);
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(rollNo) + name.hashCode();
    }



}
