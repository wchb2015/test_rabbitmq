package com.ele.java8;


import org.junit.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesTest {
    @Test
    public void test() {
        Predicate<String> predicate = (s) -> s.length() > 2;
        predicate.test("foo");    // true
        predicate.test("fo");     // false

        Predicate<Object> nonNull = Objects::nonNull;

        Object o = new Object();
        nonNull.test(o);
    }

    @Test
    public void testSupplier() {

        Supplier<Person2> personSupplierWithNoParameter = Person2::new;
        personSupplierWithNoParameter.get();   // new Person

       /* Supplier<Person2> personSupplierWithParameter = (firstName,lastName)->{ new Person2(firstName,lastName)};
        personSupplierWithParameter.get();*/

    }

    @Test
    public void testConsumer() {
        Consumer<Person2> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person2("zhang", "san"));
    }

    @Test
    public void testOptional() {
        String s = null;

        Optional<String> optional = Optional.of(s);

        System.out.println(optional.isPresent());

    }


}
