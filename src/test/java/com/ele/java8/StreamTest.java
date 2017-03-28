package com.ele.java8;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class StreamTest {
    static List<String> stringCollection = new ArrayList<>();

    static {
        stringCollection.add("ddd2");
        stringCollection.add("aaa2e");
        stringCollection.add("bbb1aaa");
        stringCollection.add("aaa1edd");
        stringCollection.add("bbb3");
        stringCollection.add("ccce");
        stringCollection.add("bbb2");
        stringCollection.add("ddd13");
    }

    @Test
    public void test09() {
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        //ddd2#aaa2e#bbb1aaa#aaa1edd#bbb3#ccce#bbb2#ddd13

    }

    @Test
    public void test02() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
        Stream<String> stringStream = Stream.of("test");
    }

    @Test
    public void test01() {
        List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6);
        long count = nums.stream().filter(num -> num != null).count();
        System.out.println(count);
    }

    @Test
    public void test03() {
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
    }

    @Test
    public void test04() {
        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).forEach(integer -> System.out.println(integer));
    }

    @Test
    public void test05() {
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach((s -> {
                    System.out.println(s);
                }));
    }

    @Test
    public void test06() {
        stringCollection
                .stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("-----");
        stringCollection
                .stream()
                .sorted((o1, o2) -> {
                    return o1.length() - o2.length();
                })
                .forEach(System.out::println);

        //Comparator.comparingInt
        stringCollection
                .stream()
                .sorted((o1, o2) -> {
                    return o1.length() - o2.length();
                })
                .forEach(System.out::println);
    }

    @Test
    public void test07() {
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void test08() {
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true
    }


    @Test
    public void test10() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        long p_t0 = System.nanoTime();

        long p_count = values.parallelStream().sorted().count();
        System.out.println(p_count);

        long p_t1 = System.nanoTime();

        long p_millis = TimeUnit.NANOSECONDS.toMillis(p_t1 - p_t0);
        System.out.println(String.format("parallel sort took: %d ms", p_millis));

    }

    @Test
    public void test11() {
        Map<Integer, String> map = new HashMap<>();

        for (Integer i = 0; i < 10; i++) {
            if (i == 9) {
//                i = null;
            }
            System.out.println("_____" + map.putIfAbsent(i, "val" + i));
        }

        for (Integer i = 0; i < 10; i++) {
            if (i == 9) {
//                i = null;
            }
            System.out.println("++++++ " + map.putIfAbsent(i, "val" + i));
        }


        map.forEach((id, val) -> System.out.println(val));
    }

}
