package org.example.Interview_prep;

import java.util.concurrent.CompletableFuture;

public class Completable {

    public static void main(String[] args) {


        CompletableFuture<String> futureData = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.currentThread().sleep(1000);
                return "data1";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> futureDat2 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "data2";
        });
        CompletableFuture<String> combinedFuture = futureData.thenCombine(futureDat2,
                (user, orders) -> {
                    return user + " | " + orders;
                });
    }
}
