package com.ele.java8;


public interface IDefaultDemo {

    void method();

    default String method2() {
        System.out.println(" method in interface !");
        return null;
    }

    static void staticMethod() {
        System.out.println("static method define in interface");
    }
}
