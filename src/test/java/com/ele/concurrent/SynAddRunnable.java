package com.ele.concurrent;

/**
 * 死锁代码样例
 */
public class SynAddRunnable implements Runnable {

    int a, b;

    public SynAddRunnable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            System.out.println(Thread.currentThread().getName() + " get lock A");
            synchronized (Integer.valueOf(b)) {
                System.out.println(Thread.currentThread().getName() + " get lock B");
                System.out.println("a+b = " + (a + b));
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }
}
