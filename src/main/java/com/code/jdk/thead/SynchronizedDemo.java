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

    public static void main(String[] args) throws InterruptedException {
        //交替打印123
        //sync();
        //死锁
        //dealLock();
        // 线程优先级
        //join();
        //中断线程
        //interrupt();
    }

    private static void interrupt() throws InterruptedException {
        Thread t1 = new Thread() {
            @Override public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + "----线程已中断");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "----" + sum.incrementAndGet());
                }
            }
        };
        t1.start();
        Thread.sleep(5);
        t1.interrupt();
    }

    private static void dealLock() {
        Object l1 = new Object();
        Object l2 = new Object();
        Thread t1 = new Thread() {
            @Override public void run() {
                synchronized (l1) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (l2) {
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override public void run() {
                synchronized (l2) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (l1) {

                    }
                }
            }
        };
        t1.setName("t1");
        t1.start();
        t2.setName("t1");
        t2.start();
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

    public static void join() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (sum.get() < 100) {
                System.out.println(Thread.currentThread().getName() + "----" + sum.incrementAndGet());
            }
        });
        Thread t2 = new Thread(() -> {
            while (sum.get() < 100) {
                System.out.println(Thread.currentThread().getName() + "----" + sum.incrementAndGet());
            }

        });
        Thread t3 = new Thread(() -> {
            while (sum.get() < 100) {
                System.out.println(Thread.currentThread().getName() + "----" + sum.incrementAndGet());
            }
        });

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        //        t3.start();
        t2.join();
    }
}
