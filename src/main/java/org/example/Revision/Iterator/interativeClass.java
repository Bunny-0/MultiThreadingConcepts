package org.example.Revision.Iterator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class interativeClass {


    public static void main(String[] args) {

//
//        List<Transaction> transactionList=new ArrayList<>();
//        transactionList.add(new Transaction(1,1000,"CREDIT"));
//        transactionList.add(new Transaction(2,2000,"DEBIT"));
//        transactionList.add(new Transaction(3,3000,"CREDIT"));
//        transactionList.add(new Transaction(4,4000,"DEBIT"));
//
//        ListIterator<Transaction> listIterator= transactionList.listIterator();
//
//        while(listIterator.hasNext()){
//            System.out.println(listIterator.next());
//            transactionList.add(new Transaction(5,5000,"CREDIT"));
//        }

        List<Transaction> transactionList=new CopyOnWriteArrayList<>();
        transactionList.add(new Transaction(1,1000,"CREDIT"));
        transactionList.add(new Transaction(2,2000,"DEBIT"));
        transactionList.add(new Transaction(3,3000,"CREDIT"));
        transactionList.add(new Transaction(4,4000,"DEBIT"));

        Iterator<Transaction> iterator= transactionList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            transactionList.add(new Transaction(5,5000,"CREDIT"));

        }
    }
}
