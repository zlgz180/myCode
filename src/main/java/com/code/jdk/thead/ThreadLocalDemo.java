package com.code.jdk.thead;

/**
 * @author tianwei
 * @since 2019-03-27 21:47
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<>();
        local.set(123);
        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());
    }
}
