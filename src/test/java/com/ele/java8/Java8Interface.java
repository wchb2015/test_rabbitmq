package com.ele.java8;

@FunctionalInterface
public interface Java8Interface {

    void method();

    default String defaultMethod() {
        System.out.println("Java8Interface.defaultMethod");
        return "";
    }

    static String staticMethod() {
        System.out.println("Java8Interface.staticMethod");
        return "";
    }
}
