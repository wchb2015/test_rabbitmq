package com.ele.java8;


public interface Person2Factory<P extends Person2> {
    P create(String firstName, String lastName);

}
