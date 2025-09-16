package org.example.Revision.OOP;

public interface Worker {

    void performDuties();
    default void logAction(String task){
        System.out.println("Work Logged: " + task);
    }

    static boolean workingHours(int hour){
        return hour>=9 && hour<=17;
    }
}
