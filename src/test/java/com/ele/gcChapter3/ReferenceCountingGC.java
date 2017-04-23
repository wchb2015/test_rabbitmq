package com.ele.gcChapter3;

/**
 * 引用计数法
 * <p>
 * VM args:-XX:+PrintGCDetail
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存,以便能在GC日志中看清楚是否被回收过.
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;

        objB = null;

        //假设在这行发生GC,objA和objB是否能被回收

        System.gc();

    }

    public static void main(String[] args) {
        testGC();
    }

}
/*
[GC (Allocation Failure) [DefNew: 2578K->258K(4928K), 0.0023213 secs] 2578K->2306K(15872K), 0.0023696 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
        [Full GC (System.gc()) [Tenured: 2048K->256K(10944K), 0.0017889 secs] 4439K->256K(15872K), [Metaspace: 2477K->2477K(1056768K)], 0.0020174 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
        Heap
        def new generation   total 4992K, used 89K [0x00000000f0800000, 0x00000000f0d60000, 0x00000000f5aa0000)
        eden space 4480K,   2% used [0x00000000f0800000, 0x00000000f08167d8, 0x00000000f0c60000)
        from space 512K,   0% used [0x00000000f0c60000, 0x00000000f0c60000, 0x00000000f0ce0000)
        to   space 512K,   0% used [0x00000000f0ce0000, 0x00000000f0ce0000, 0x00000000f0d60000)
        tenured generation   total 10944K, used 256K [0x00000000f5aa0000, 0x00000000f6550000, 0x0000000100000000)
        the space 10944K,   2% used [0x00000000f5aa0000, 0x00000000f5ae0298, 0x00000000f5ae0400, 0x00000000f6550000)
        Metaspace       used 2483K, capacity 4486K, committed 4864K, reserved 1056768K
class space    used 267K, capacity 386K, committed 512K, reserved 1048576K
*/
