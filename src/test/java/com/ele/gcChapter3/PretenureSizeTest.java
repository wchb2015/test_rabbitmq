package com.ele.gcChapter3;

/**
 * 大对象直接进入老年代
 * <p>
 * VM args:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 */
public class PretenureSizeTest {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;

        allocation = new byte[4 * _1MB];


    }

}
/*
Heap
        def new generation   total 9216K, used 835K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
        eden space 8192K,  10% used [0x00000000fec00000, 0x00000000fecd0f20, 0x00000000ff400000)
        from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
        to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
        tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
        the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00010, 0x00000000ffa00200, 0x0000000100000000)
        Metaspace       used 2482K, capacity 4486K, committed 4864K, reserved 1056768K
class space    used 267K, capacity 386K, committed 512K, reserved 1048576K*/
