package com.ele.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest2 {

    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void test01() {
        int result = nums.stream().mapToInt(d -> d).sum();
        System.out.println(result);
    }

    @Test
    public void test02() {
        OptionalInt optionalInt = nums.stream().mapToInt(d -> d).max();
        System.out.println(optionalInt.getAsInt());

        List<Integer> list = nums.stream().collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void test03() {
        IntStream intStream = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(intStream.count());
    }

    @Test
    public void test04() {
        System.out.println(1_000_000);
    }

    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {

            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

}
