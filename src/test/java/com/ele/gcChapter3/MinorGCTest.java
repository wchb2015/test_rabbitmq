package com.ele.gcChapter3;

/**
 * 新生代MinorGC
 */
public class MinorGCTest {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM args:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次MinorGC

    }

    public static void main(String[] args) {

        testAllocation();
    }
}
/*
[GC (Allocation Failure) [DefNew: 6815K->258K(9216K), 0.0047049 secs] 6815K->6402K(19456K), 0.0048323 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
        Heap
        def new generation   total 9216K, used 4436K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
        eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff014930, 0x00000000ff400000)
        from space 1024K,  25% used [0x00000000ff500000, 0x00000000ff5408e0, 0x00000000ff600000)
        to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
        tenured generation   total 10240K, used 6144K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
        the space 10240K,  60% used [0x00000000ff600000, 0x00000000ffc00030, 0x00000000ffc00200, 0x0000000100000000)
        Metaspace       used 2482K, capacity 4486K, committed 4864K, reserved 1056768K
class space    used 267K, capacity 386K, committed 512K, reserved 1048576K*/
