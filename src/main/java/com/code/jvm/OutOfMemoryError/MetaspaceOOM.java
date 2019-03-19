package com.code.jvm.OutOfMemoryError;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * -XX:MetaspaceSize=1M -XX:MaxMetaspaceSize=100M
 * 
 * @author tianwei
 * @since 2019/3/19 15:18
 */
public class MetaspaceOOM {

    static int i = 0;

    public static void main(String[] args) {
        while (true) {
            // cglib反射 class信息会进入持久代
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            System.out.println(i++);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invoke(obj, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {
    }
}
