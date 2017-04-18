package com.ele.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常
 * <p>
 * VM args:-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 *
 * 疑问:free -h 看 消耗的内存在400M+
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用list保持着常量池引用,避免full gc回收常量池行为
        List<String> list = new ArrayList<>();
        //10MB的Metaspace在integer范围内足够产生oom了.
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
