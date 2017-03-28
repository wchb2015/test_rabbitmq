package com.ele.java8;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8LambdaTest {

    @Test
    public void test() {
        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));

        List list = new ArrayList();
//        Arrays.asList("a", "b", "d").forEach(list);
    }

    @Test
    public void test01() {
        List<String> names = new ArrayList<>();
        names.add("TaoBao");
        names.add("ZhiFuBao");

        List<String> lowercaseNames = names.stream().map((String name) -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());

        System.out.println(lowercaseNames);
    }

    @Test
    public void test02() {
        String[] array = {"a", "b", "c"};
        for (Integer i : Lists.newArrayList(1, 2, 3)) {
            Stream.of(array).map(item -> Strings.padEnd(item, i, '@')).forEach(System.out::println);
        }
    }

    @Test
    public void test03() {
       /* List<String> names = new ArrayList<>();
        names.add("TaoBao");
        names.add("ZhiFuBao");*/
        List<String> names = Arrays.asList("aA", "bB", "dD");
        List<String> lowercaseNames = names.stream().map((String name) -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());
        System.out.println(lowercaseNames);
        Stream<String> stream = names.stream();

    }

    @Test
    public void test04() {
        List<String> list = Arrays.asList("zdd", "ad", "a", "fffe");
//      匿名内部类方式
        Collections.sort(list, new Comparator<String>() {// 接口名
            @Override
            public int compare(String s1, String s2) {// 方法名
                if (s1 == null)
                    return -1;
                if (s2 == null)
                    return 1;
                return s1.length() - s2.length();
            }
        });
//      Lambda方式
        Collections.sort(list, (s1, s2) -> {// 省略参数表的类型
            if (s1 == null)
                return -1;
            if (s2 == null)
                return 1;
            return s1.length() - s2.length();
        });

        System.out.println(list);
    }

    @Test
    public void test05() {
        String[] array = {"a", "b", "c"};
        for (int i = 1; i < 4; i++) {
//            Stream.of(array).map(item -> Strings.padEnd(item, i, '@')).forEach(System.out::println);
        }
    }

    @Test
    public void test06() {
        List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6);
        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
                collect(Collectors.toList());
        System.out.println(numsWithoutNull);
    }

    @Test
    public void test07() {
        List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());

        List<Integer> ints2 = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("ints size is:" + ints2.stream().count());
    }

}
