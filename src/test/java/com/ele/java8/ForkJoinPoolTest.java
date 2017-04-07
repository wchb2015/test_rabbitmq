package com.ele.java8;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class ForkJoinPoolTest {

    ForkJoinPool forkJoinPool = new ForkJoinPool();


    @Test
    public void test01() throws ExecutionException, InterruptedException {
        System.out.println(Thread.activeCount());

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        List<Integer> result = forkJoinPool.submit(() -> nums.parallelStream().map(n -> n * n).collect(Collectors.toList())).get();
        System.out.println(Thread.activeCount());
        System.out.println(result);


        System.out.println("pool size : " + forkJoinPool.getPoolSize());
        System.out.println("pool parallelism : " + forkJoinPool.getParallelism());
    }


}
