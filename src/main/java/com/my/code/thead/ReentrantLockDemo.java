package com.my.code.thead;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 启动两个线程, 一个输出 1,3,5,7…99, 另一个输出 2,4,6,8…100 最后 STDOUT 中按序输出 1,2,3,4,5…100
 * 
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class ReentrantLockDemo {
    private static int SUM = 1;
    private static int MAX = 100;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        //
        reentrantLock();
    }

    public static void reentrantLock() {
        Thread t2 = new Thread(() -> {
            while (SUM < MAX) {
                // try尝试获取锁，没有锁就跳过
                // lock.tryLock();
                // 直接锁，没有锁就阻塞
                lock.lock();
                try {
                    if (SUM % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "----" + SUM++);
                    }
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t1 = new Thread(() -> {
            while (SUM < MAX) {
                lock.lock();
                try {
                    if (SUM % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "----" + SUM++);
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
