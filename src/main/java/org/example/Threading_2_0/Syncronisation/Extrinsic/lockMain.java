package org.example.Threading_2_0.Syncronisation.Extrinsic;

public class lockMain {


    public static void main(String args[]) throws InterruptedException {
        Withdraw withdraw = new Withdraw();
        Thread th1 = new Thread(()->{

                try {
                    withdraw.withdrawUsingInterruptedAmount(200);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


        });
        Thread th2 = new Thread(()->{

                try {
                    withdraw.withdrawUsingInterruptedAmount(200);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

        });

        th1.start();
        th2.start();
        System.out.println("Final Balance: " + withdraw.getBalance());
    }
}
