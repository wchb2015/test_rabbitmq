package com.ele.gc;


import org.junit.Test;

public class StringInternTest {

    @Test
    public void test() {

        String str1 = new StringBuilder("计算机").append("软件").toString();

        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va1").toString();

        System.out.println(str2.intern() == str2);

    }
}
