package org.example.Revision.comparision;

public class Transaction implements Comparable<Transaction>{
    int amount;
    String date;
    String transactionId;
    String fromUser;
    String toUser;

    public Transaction(int i, String s, String t1, String a, String b) {
        this.amount=i;
        this.date=s;
        this.transactionId=t1;
        this.fromUser=a;
        this.toUser=b;
    }

    @Override
    public int compareTo(Transaction o) {
        return this.date.compareTo(o.date);

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date='" + date + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                '}';
    }
}
