package com.ele.java8;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
                .sorted().forEach(System.out::print);
        ;
        System.out.println("-----" + stringCollection);

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
        System.out.println("list size : " + count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        long p_t0 = System.nanoTime();

        long p_count = values.parallelStream().sorted().count();
        System.out.println("list size : " + p_count);

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

    @Test
    public void test12() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println(squareNums);
    }

    @Test
    public void test13() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
    }

    @Test
    public void test14() {
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens =
                Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);

        System.out.println(evens);
    }

    @Test
    public void test15() {
        List list = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        System.out.println("___" + list);
    }

    @Test
    public void test16() {
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        List<String> personList2 = persons.stream().
                map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(personList2);
    }

    @Test
    public void test17() {
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        List<Person> personList2 = persons.stream().sorted((p1, p2) ->
                p1.getName().compareTo(p2.getName())).limit(2).collect(Collectors.toList());
        System.out.println(personList2);
    }

    @Test
    public void test18() {
        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        sl.forEach(s -> l.add("three"));
    }

    @Test
    public void test19() {
        List<String> l = Stream.of("a", "b", "c", "b").distinct().collect(Collectors.toList());
        System.out.println(l); //[a, b, c]
    }

    @Test
    public void test20() {
        List<Integer> l = IntStream.range(1, 10).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
        System.out.println(l); //[2, 4, 6, 8]
    }

    @Test
    public void test21() {
        List<Integer> l = Stream.of('a', 'b', 'c').map(c -> c.hashCode()).collect(Collectors.toList());
        System.out.println(l); //[97, 98, 99]
    }

    @Test
    public void test22() {
        String poetry = "Where, before me, are the ages that have gone?/n" + "And where, behind me, are the coming generations?/n" + "I think of heaven and earth, without limit, without end,/n" + "And I am all alone and my tears fall down.";
        Stream<String> lines = Arrays.stream(poetry.split("/n"));
        Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(" ")));
        List<String> l = words.map(w -> {
            if (w.endsWith(",") || w.endsWith(".") || w.endsWith("?"))
                return w.substring(0, w.length() - 1).trim().toLowerCase();
            else return w.trim().toLowerCase();
        }).distinct().sorted().collect(Collectors.toList());
        System.out.println(l); //[ages, all, alone, am, and, are, before, behind, coming, down, earth, end, fall, generations, gone, have, heaven, i, limit, me, my, of, tears, that, the, think, where, without]
    }

    @Test
    public void test23() {
        String question = "java";

        List<String> engines = new ArrayList<String>() {{
            add("http://www.google.com/?q=");
            add("http://duckduckgo.com/?q=");
            add("http://www.bing.com/search?q=");
        }};

        // get element as soon as it is available
        Optional<String> result = engines.stream().parallel().map((base) -> {
            return base + question;
            // open connection and fetch the result
            //return WS.url(url).get();
        }).findFirst();

        System.out.println("result: " + result.get());
    }

    @Test
    public void test24() {
        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        String s = sl.collect(joining(" "));
    }

    @Test
    public void test25() {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        hiddenFiles.hashCode();
    }

    @Test
    public void test26() {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println(evenNumbers.test(11));

        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;

        System.out.println(oddNumbers.test(999));

    }

    private <A, R> Collector<? super String, A, R> joining(String s) {
        return null;
    }

    class Person {
        public int no;
        private String name;

        public Person(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public String getName() {

            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}