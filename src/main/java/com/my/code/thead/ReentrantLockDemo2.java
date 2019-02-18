package com.my.code.thead;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程交替打印abc
 * 
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class ReentrantLockDemo2 {
    private static int SUM = 1;
    private static int MAX = 100;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition aLock = lock.newCondition();
    private static Condition bLock = lock.newCondition();
    private static Condition cLock = lock.newCondition();

    public static void main(String[] args) {
        new ReentrantLockDemo2().reentrantLock();
    }

    public void reentrantLock() {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(2);
        MyThread t3 = new MyThread(0);
        t1.setName("t1");
        t1.start();
        t2.setName("t2");
        t2.start();
        t3.setName("t3");
        t3.start();
    }

    public class MyThread extends Thread {
        int flag;

        public MyThread(int flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            while (SUM < MAX) {
                lock.lock();
                try {
                    if (SUM % 3 != flag) {
                        continue;
                    }
                    System.out.println(Thread.currentThread().getName() + "----" + SUM++);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
