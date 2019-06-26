package com.code.jdk.thead;

/**
 * 3个线程交替打印---ABC
 *
 * @author tianwei
 * @since 2019/6/26 14:46
 */
public class ABCThreadPrint2 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Object lock3 = new Object();
    private static volatile int count = 0;

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
        new Thread3().start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            while (count <= 6) {
                // synchronized (lock1) {
                if (count % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + "---A");
                    count++;
                }
                // }
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            while (count <= 6) {
                // synchronized (lock1) {
                if (count % 3 == 1) {
                    System.out.println(Thread.currentThread().getName() + "---B");
                    count++;
                }
                // }
            }
        }
    }

    static class Thread3 extends Thread {
        @Override
        public void run() {
            while (count <= 6) {
                // synchronized (lock1) {
                if (count % 3 == 2) {
                    System.out.println(Thread.currentThread().getName() + "---C");
                    count++;
                }
                // }
            }
        }
    }
}
