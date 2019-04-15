package com.code.jvm.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author tianwei
 * @since 2019-04-01 14:35
 */
public class ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        // 初始化类，static
        Class.forName("");

        // 不会初始化
        Thread.currentThread().getContextClassLoader().loadClass("");

        // jdk 反射
        Proxy.newProxyInstance(ClassLoader.class.getClassLoader(), new Class[] { MyReflectInterface.class },
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return proxy;
                    }
                });

        // cglib
        Enhancer enhancer = new Enhancer();
        Object o = Enhancer.create(MyReflectInterface.class, null);
    }
}
