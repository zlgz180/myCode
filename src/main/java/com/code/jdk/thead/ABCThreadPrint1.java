package com.code.jdk.thead;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程交替打印---ABC
 *
 * @author tianwei
 * @since 2019/6/26 14:46
 */
public class ABCThreadPrint1 {
    private final static ReentrantLock reentrantLock = new ReentrantLock();
    private static volatile int state = 1;

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10;) {
                    try {
                        reentrantLock.lock();
                        while (state % 3 == 0) {
                            // System.out.println(Thread.currentThread().getName() + "--C");
                            System.out.println(Thread.currentThread().getName() + "--" + state);
                            state++;
                            i++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10;) {
                    try {
                        reentrantLock.lock();
                        if (state % 3 == 1) {
                            // System.out.println(Thread.currentThread().getName() + "--C");
                            System.out.println(Thread.currentThread().getName() + "--" + state);
                            state++;
                            i++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10;) {
                    try {
                        reentrantLock.lock();
                        if (state % 3 == 2) {
                            // System.out.println(Thread.currentThread().getName() + "--C");
                            System.out.println(Thread.currentThread().getName() + "--" + state);
                            state++;
                            i++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
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
