package com.ele.gc;


import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出测试
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
