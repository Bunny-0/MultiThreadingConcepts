package org.example.Revision.comparision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparision {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>(List.of(
                new Transaction(1000,"2023-02-01","T1","A","B"),
                new Transaction(500,"2023-01-01","T2","C","D"),
                new Transaction(2000,"2022-12-31","T3","E","F")
        ));

        Comparator<Transaction> txnDesc=(a,b)->Double.compare(a.amount,b.amount);
        Collections.sort(transactions,txnDesc);

//        Collections.sort(transactions);
//        System.out.println(transactions);

        Comparator<Transaction> amountDesc = (t1, t2) -> Double.compare(t2.amount, t1.amount);
        Collections.sort(transactions, amountDesc);
        System.out.println(transactions);
    }
}
