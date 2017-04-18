package com.ele.java8;


import org.junit.Test;

import java.util.List;

public class DefaultMethodConflict implements IFunction2 {

    @Override
    public String methodWithOneParameter(String name) throws RuntimeException {
        return null;
    }

    @Override
    public List<String> covert2StringList(IFunction2 function2) {
        return null;
    }

    /*@Override
    public void methodConflict() {
        System.out.println("DefaultMethodConflict");
    }*/


    @Test
    public void test() {
        this.methodConflict();
    }
}
