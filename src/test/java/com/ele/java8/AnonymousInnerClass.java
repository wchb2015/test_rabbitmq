package com.ele.java8;


import org.junit.Test;

abstract class AbsPerson {
    public abstract void eat(String sth);
}

public class AnonymousInnerClass {

    private final String name = null;

    public static void main(String[] args) {
        AbsPerson p = new AbsPerson() {
            @Override
            public void eat(String sth) {
                System.out.println("eat " + sth);
            }
        };

        p.eat("meat");

    }

    Integer i = 2;
    final Integer finInteger = 1;
    Object object = new Object();

    @Test
    public void test01() {

        int i1 = 10;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running!");
                System.out.println("i=" + i1);
                System.out.println("object=" + object.hashCode());
                i++;
            }
        });
        t.start();

        Thread t1 = new Thread(() -> {
            System.out.println("Lambda running");
            i++;
            System.out.println("Lambda i=" + i1);
            System.out.println("Lambda object=" + object.hashCode());

        });
        t1.start();
    }


    @Test
    public void test02() {
        int i = 16;
        Runnable r = new Runnable() {
            public void run() {
                int i = 0; // fine
                System.out.println("i is: " + i);

            }
        };
        new Thread(r).start();
    }

    @Test
    public void test03() {
        int i = 16;
        Runnable r = () -> {
            int i1 = 0; // error:variable i is already define in the scope
            System.out.println("Lambda this: " + this.getClass().getName());
            System.out.println("Lambda this: " + super.getClass().getName());
            System.out.println("cnt is: " + i1);
        };

        new Thread(r).start();
    }
}
