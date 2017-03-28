package com.ele.java8;


import com.ele.AbsClass;
import org.junit.Test;

public class Java8InterfaceImpl extends AbsClass implements Java8Interface {

    @Test
    public void test() {
        Java8Interface.staticMethod();

        Java8InterfaceImpl impl = new Java8InterfaceImpl();

        impl.defaultMethod();

        impl.method();
    }

    @Override
    public String defaultMethod() {
        System.out.println("Override  Java8InterfaceImpl.defaultMethod");
        return null;
    }

    @Override
    public void abstractMethod() {

    }
}
