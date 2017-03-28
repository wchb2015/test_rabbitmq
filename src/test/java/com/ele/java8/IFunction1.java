package com.ele.java8;

@FunctionalInterface
public interface IFunction1 {

    void methodWithNoParameter();

    static void staticMethod() {
        System.out.println("IFunction1.staticMethod");
    }
}
