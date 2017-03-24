package com.ele.java8;


import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
}
