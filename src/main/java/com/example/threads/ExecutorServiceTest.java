package com.example.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            System.out.println("Task 1 is running");
            System.out.println("Running in thread: " +
                    Thread.currentThread().getName());
        });

        executorService.submit(() -> {
            System.out.println("Task 2 is running");
            System.out.println("Running in thread: " +
                    Thread.currentThread().getName());

        });
    }
}
