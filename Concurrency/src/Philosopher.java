package ch_1;

import java.util.Random;

public class Philosopher extends Thread {
    class Chopstick {
    }

    private Chopstick left, right;
    private Random random;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
        this.random = new Random();
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                synchronized (left) {
                    synchronized (right) {
                        Thread.sleep(random.nextInt(1000));
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }
}