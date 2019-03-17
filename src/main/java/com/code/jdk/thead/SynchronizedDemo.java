package com.code.jdk.thead;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 启动两个线程, 一个输出 1,3,5,7…99, 另一个输出 2,4,6,8…100 最后 STDOUT 中按序输出 1,2,3,4,5…100
 *
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class SynchronizedDemo {
    private static AtomicInteger sum = new AtomicInteger(1);
    private static Object lock = new Object();

    public static void main(String[] args) {
        // synchronized
        sync();
    }

    /**
     * 必须使用notify
     */
    public static void sync() {
        Thread t1 = new Thread(() -> {
            while (sum.get() < 100) {
                synchronized (lock) {
                    try {
                        if (sum.get() % 3 != 0) {
                            lock.wait();
                            continue;
                        }
                        System.out.println(Thread.currentThread().getName() + "----" + sum.incrementAndGet());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (sum.get() < 100) {
                synchronized (lock) {
                    try {
                        if (sum.get() % 3 != 1) {
                            lock.wait();
                            continue;
                        }
                        System.out.println(Thread.currentThread().getName() + "----" + sum.incrementAndGet());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (sum.get() < 100) {
                synchronized (lock) {
                    try {
                        if (sum.get() % 3 != 2) {
                            lock.wait();
                            continue;
                        }
                        System.out.println(Thread.currentThread().getName() + "----" + sum.incrementAndGet());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }

    public static void join() {
        Thread t1 = new Thread(() -> {
            while (sum.get() < 100) {
                System.out.println(sum.incrementAndGet());

            }
        });
        Thread t2 = new Thread(() -> {
            while (sum.get() < 100) {
                System.out.println(sum.incrementAndGet());
            }
        });

        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
