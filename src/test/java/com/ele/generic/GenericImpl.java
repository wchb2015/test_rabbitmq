package com.ele.generic;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericImpl {

    List<?> unknownList;
    List<? extends Number> unknownNumberList;
    List<? super Integer> unknownBaseLineIntgerList;


    @Test
    public void test() {
        unknownList = new ArrayList<Scanner>();

        unknownNumberList = new ArrayList<Integer>();

        unknownBaseLineIntgerList = new ArrayList<Number>();
    }
}
