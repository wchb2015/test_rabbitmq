package com.ele.java8;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Test {

    @Test
    public void test01() {
        System.out.println(Math.sqrt(10));
    }

    @Test
    public void test02() {
        IDefaultDemo defaultDemo = new IDefaultDemo() {
            @Override
            public void method() {
                System.out.println("This method defined in sub class!");
            }
        };

        defaultDemo.method();
        defaultDemo.method2();
    }

    @Test
    public void test03() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        System.out.println(names);

        Collections.sort(names, (a, b) -> {
            return a.compareTo(b);
        });

        System.out.println(names);

    }


    @Test
    public void test05() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        new Thread(runnable).start();
    }

    @Test
    public void test055() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();
    }

    @Test
    public void test06() {
        new Thread(() -> System.out.println("hello")).start();
    }

    @Test
    public void test07() {
        List<String> strs = Arrays.asList("D", "a", "e", "b");

        Collections.sort(strs, String::compareToIgnoreCase);

        System.out.println(strs);

    }

    @Test
    public void test08() {
        IDefaultDemo.staticMethod();
    }
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}