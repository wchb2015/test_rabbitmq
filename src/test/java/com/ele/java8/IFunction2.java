package com.ele.java8;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface IFunction2 {

    String methodWithOneParameter(String name) throws RuntimeException;

    default List<String> covert2StringList(IFunction2 function2) {
        if (function2 == null) return null;
        List<String> stringList = new ArrayList<>();
        stringList.add(function2.methodWithOneParameter("haha"));
        return stringList;
    }

    default void methodConflict() {
        System.out.println("IFunction2");
    }
}
