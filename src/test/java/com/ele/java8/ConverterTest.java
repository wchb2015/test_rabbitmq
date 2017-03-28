package com.ele.java8;


import org.junit.Test;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConverterTest {

    static int outerStaticNum;
    int outerNum;

    @Test
    public void test() {
        Converter<String, Integer> converter = (outerNum) -> Integer.valueOf(outerNum);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

    @Test
    public void test01() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123
    }

    @Test
    public void test02() {
        int num = 1;

        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        String i = stringConverter.convert(2);     // 3

        System.out.println(i);
    }

    @Test
    public void test03() {
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test(""));           // true
        System.out.println(predicate.negate().test("foo"));  //false


        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

    @Test
    public void test04() {
        Consumer<Person2> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person2("Luke", "Skywalker"));
    }
}
