package com.ele.java8;

import org.junit.Test;

import java.util.List;

public class IFunctionTest {

    @Test
    public void test() {

        IFunction1 function1 = () -> {
            System.out.println(" function 1 !");
        };

        function1.methodWithNoParameter();
    }

    @Test
    public void test2() throws Exception {

        IFunction2 function2 = name -> {
            String result = "hello " + name;
            System.out.println(result);
            return result;
        };

        function2.methodWithOneParameter("zhangsan ");
    }

    @Test
    public void test3() {

        IFunction3 function3 = (name, age) -> {
            String result = "hello :" + name + ", age : " + age;
            System.out.println(result);
            return result;
        };

        try {
            function3.methodWithTwoParameter("zhangsan", Integer.valueOf(11));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        IFunction2 function2 = name -> {
            String result = "hello " + name;
            System.out.println(result);
            return result;
        };

        List<String> result = function2.covert2StringList((name) -> "hello2 " + name);

        System.out.println(result);

    }

    @Test
    public void test5() {
        IFunction1.staticMethod();
    }
}
