package org.example.Interview_prep;

public class Seq {

    public static void main(String[] args) {
        Printer obj = new Printer();

        Thread th1 = new Thread(() -> {
            try {
                obj.printNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread th2 = new Thread(() -> {
            try {
                obj.printAlpha();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        th1.start();
        th2.start();
    }
}

class Printer {

    volatile boolean numberTurn = false;
    int num = 1;
    int target = 26;
    char ch = 'a';

    public synchronized void printNumber() throws InterruptedException {
        while (num <= target) {
            while (!numberTurn) {
                wait();
            }
            System.out.print(num + " ");
            num++;
            numberTurn = false;
            notify();
        }
    }

    public synchronized void printAlpha() throws InterruptedException {
        while (ch <= 'z') {
            while (numberTurn) {
                wait();
            }
            System.out.print(ch + " ");
            ch++;
            numberTurn = true;
            notify();
        }
    }
}
