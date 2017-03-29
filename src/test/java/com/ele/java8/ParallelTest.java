package com.ele.java8;


import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.Math.sqrt;
import static java.util.stream.IntStream.range;
import static java.util.stream.LongStream.rangeClosed;

public class ParallelTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        es.execute(() -> runTask(1000)); //incorrect task
        es.execute(() -> runTask(0));
        es.execute(() -> runTask(0));
        es.execute(() -> runTask(0));
        es.execute(() -> runTask(0));
        es.execute(() -> runTask(0));

        es.shutdown();
        es.awaitTermination(60, TimeUnit.SECONDS);
    }

    private static void runTask(int delay) {
        range(1, 1_000_000).parallel().filter(ParallelTest::isPrime).peek(i -> {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).max().ifPresent(max -> System.out.println(Thread.currentThread() + " " + max));
    }

    public static boolean isPrime(long n) {
        return n > 1 && rangeClosed(2, (long) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }

    @Test
    public void testLongStream() {
        Runnable r = () -> IntStream
                .range(-42, +42)
                .parallel()
                .map(i -> Thread.activeCount())
                .max()
                .ifPresent(System.out::println);

        ForkJoinPool.commonPool().submit(r).join();
        new ForkJoinPool(42).submit(r).join();
    }

    @Test
    public void test() {
        Runnable r = () -> IntStream
                .range(-42, +42)
                .parallel()
                .map(i -> i * 1)
                .forEach(System.out::println);

        new Thread(r).start();
    }
}
