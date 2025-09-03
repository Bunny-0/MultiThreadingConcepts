package org.example.Revision.Iterator;

public class Transaction {
    private int id;
    private double amount;
    private String type; // CREDIT or DEBIT

    public Transaction(int id, double amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
