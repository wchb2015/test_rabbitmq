package com.ele.concurrent;


public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println("Thread is going to yield!!!___" + Thread.currentThread().getName());
                Thread.yield();
            }
            System.out.println(number + "___" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();

        Thread.sleep(1000);

        number = 42;
        ready = true;

        System.out.println("end");
    }
}
