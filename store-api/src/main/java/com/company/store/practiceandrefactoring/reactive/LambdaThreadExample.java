package com.company.store.practiceandrefactoring.reactive;

public class LambdaThreadExample {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();
    }
}
