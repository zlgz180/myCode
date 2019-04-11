package com.code.jdk.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianwei
 * @since 2019-03-27 21:47
 */
public class ThreadLocalDemo {
    private static Integer sss = new Integer(1);
    private static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) {

         local.set(sss);
        // System.out.println(local.get());
        // local.remove();
        // System.out.println(local.get());
        plus();
    }

    private static void plus() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Integer a = local.get();
                    local.set(++a);
                    System.out.println("plus:" + Thread.currentThread().getName() + ": " + a);
                }
            });
        }
        executorService.shutdown();
    }
}
