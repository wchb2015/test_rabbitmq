package com.ele.generic;


import java.util.Random;

public class FruitGenerator implements Generator<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }

    public static void main(String[] args) {
        FruitGenerator generator = new FruitGenerator();
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());

        out("findingsea");
        out(123);
        out(11.11);
        out(true);

        System.out.println("__________");

        out("findingsea", 123, 11.11, true);
    }

    public static <T> void out(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }

    public static <T> void out(T t) {
        System.out.println(t);
    }

    public <T, S extends T> void testGenericMethodDefine(T t, S s) {

    }

}
