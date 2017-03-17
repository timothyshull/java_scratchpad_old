package com.company;

public class TestThread {

    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("thread-2");
        R2.start();
    }
}
