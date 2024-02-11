package com.company.store.practiceandrefactoring.reactive;

public class ExtendThreadExample {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
