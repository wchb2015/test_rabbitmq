package com.ele.gc;

/**
 * 创建线程导致内存溢出异常, 注意  会导致死机.因为Java线程是映射到操作系统的内核线程上的.
 * VM Args: -Xss2M
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> dontStop()).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();

        oom.stackLeakByThread();
    }
}
