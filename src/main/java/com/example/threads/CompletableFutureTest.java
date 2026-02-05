package com.example.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task1 is running");
            System.out.println("Task1 running in thread: " +
                    Thread.currentThread().getName());
            return "Hello from CompletableFuture";
        }, executor);

        CompletableFuture future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Task2 is running");
            System.out.println("Task2 is running in thread: " +
                    Thread.currentThread().getName());
        });
    }
}
