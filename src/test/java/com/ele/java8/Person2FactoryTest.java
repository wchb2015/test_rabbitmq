package com.ele.java8;


import org.junit.Test;

public class Person2FactoryTest {

    @Test
    public void test() {
        Person2Factory<Person2> personFactory = Person2::new;
        personFactory.create("haha", "hehe");


        Person2Factory<Person2> personFactory2 = (firstName, lastName) -> {
            return new Person2(firstName, lastName);
        };


        personFactory2.create("haha", "hehe");

    }
}
