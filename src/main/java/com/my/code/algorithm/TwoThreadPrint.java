package com.my.code.algorithm;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tianwei
 * @since 2018-06-26 18:36
 */
public class TwoThreadPrint {
    private final static ReentrantLock reentrantLock = new ReentrantLock();
    private static volatile AtomicInteger sum = new AtomicInteger(1);

    public static void main(String[] args) {


        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (sum.get() <= 100) {
                    try {
                        reentrantLock.tryLock();
                        if (sum.get() % 2 != 0) {
                            System.out.println(Thread.currentThread().getName() + "--" + sum);
                            sum.incrementAndGet();
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (sum.get() <= 100) {
                    try {
                        reentrantLock.tryLock();
                        if (sum.get() % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + "--" + sum);
                            sum.incrementAndGet();
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
