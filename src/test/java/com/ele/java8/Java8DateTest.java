package com.ele.java8;


import org.junit.Test;

import java.time.LocalDateTime;

public class Java8DateTest {

    @Test
    public void test01() {
        LocalDateTime coffeeBreak = LocalDateTime.now()
                .plusHours(2)
                .plusMinutes(30);

        System.out.println(coffeeBreak.toLocalTime());
    }
}
