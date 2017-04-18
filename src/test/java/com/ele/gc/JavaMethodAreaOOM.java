package com.ele.gc;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGlib使方法区出现内存溢出异常
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);

            enhancer.setUseCache(false);

            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] args1, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o, args1);
                }
            });

            enhancer.create();
        }

    }

}

class OOMObject {

}
