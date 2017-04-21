package com.ele.concurrent;

public class StringThread implements Runnable {
    private static final String LOCK_PREFIX = "XXX---";

    private String ip;

    public StringThread(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {
        String lock = buildLock();
        synchronized (lock) {
            System.out.println("[" + Thread.currentThread().getName() + "]开始运行了" + System.currentTimeMillis());
            // 休眠5秒模拟脚本调用
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() + "]结束运行了" + System.currentTimeMillis());
        }
    }

    private String buildLock() {
        StringBuilder sb = new StringBuilder();
        sb.append(LOCK_PREFIX);
        sb.append(ip);

        String lock = sb.toString();
        System.out.println("[" + Thread.currentThread().getName() + "]构建了锁[" + lock + "]");

        return lock;
    }

}