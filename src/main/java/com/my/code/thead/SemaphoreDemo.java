package com.my.code.thead;

import java.util.concurrent.Semaphore;

/**
 * 3个线程交替打印123
 * 
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class SemaphoreDemo {
    private static int SUM = 1;
    private static int MAX = 100;
    private static Semaphore lock = new Semaphore(1);
    public static void main(String[] args) {
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

    public static class MyThread extends Thread {
        int flag;

        public MyThread(int flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            while (SUM < MAX) {
                try {
                    lock.acquire();
                    try {
                        if (SUM % 3 != flag) {
                            continue;
                        }
                        System.out.println(Thread.currentThread().getName() + "----" + SUM++);
                    } finally {
                        lock.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
