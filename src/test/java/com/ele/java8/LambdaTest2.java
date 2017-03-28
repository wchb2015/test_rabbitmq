package com.ele.java8;


import org.junit.Test;

import java.io.File;

public class LambdaTest2 {

    @Test
    public void test() {
        new Action() {
            @Override
            public void execute(String content) {
                System.out.println("______" + content);
            }

            @Override
            public void execute2(String content) {
                System.out.println("++++++" + content);

            }
        }.execute("匿名内部类!");


        /* Action action = content -> {
            System.out.println("______" + content);
        };
        action.execute("Lambda方式!"); */
    }

    interface Action {

        void execute(String content);

        void execute2(String content);

    }

    @Test
    public void test01() {
        File myDir = new File("/Users/wchb/Downloads/winTemp");
        if (myDir.isDirectory()) {
            File[] files = myDir.listFiles(
                    (File f) -> {
                        System.out.println(f.getAbsolutePath());
                        return f.isFile();
                    }
            );
        }
    }
}



