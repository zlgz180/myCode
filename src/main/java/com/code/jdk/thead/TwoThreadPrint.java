package com.code.jdk.thead;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2个线程交替打印1---100
 *
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
                        reentrantLock.lock();
                        if (sum.get() % 3 == 0) {
                            System.out.println(Thread.currentThread().getName() + "--" + sum);
                            sum.incrementAndGet();
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (sum.get() <= 100) {
                    try {
                        reentrantLock.lock();
                        if (sum.get() % 3 == 1) {
                            System.out.println(Thread.currentThread().getName() + "--" + sum);
                            sum.incrementAndGet();
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (sum.get() <= 100) {
                    try {
                        reentrantLock.lock();
                        if (sum.get() % 3 == 2) {
                            System.out.println(Thread.currentThread().getName() + "--" + sum);
                            sum.incrementAndGet();
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        };
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
