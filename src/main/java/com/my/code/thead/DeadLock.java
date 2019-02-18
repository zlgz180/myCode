package com.my.code.thead;

/**
 * 死锁
 * 
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class DeadLock {
    public static void main(String[] args) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        // 每个线程都拥有r1,r2两个对象
        Thread myTh1 = new MyThread1(r1, r2);
        Thread myTh2 = new MyThread2(r1, r2);

        myTh1.start();
        myTh2.start();
    }
}

class Resource {
    private int i;
}

class MyThread1 extends Thread {
    private Resource r1, r2;

    public MyThread1(Resource r1, Resource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        while (true) {
            // 先获得r1的锁，再获得r2的锁
            synchronized (r1) {
                System.out.println("1号线程获取了r1的锁");
                synchronized (r2) {
                    System.out.println("1号线程获取了r2的锁");
                }
            }
        }
    }
}

class MyThread2 extends Thread {
    private Resource r1, r2;

    public MyThread2(Resource r1, Resource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        while (true) {
            // 先获得r2的锁，再获得r1的锁
            synchronized (r2) {
                System.out.println("2号线程获取了r2的锁");
                synchronized (r1) {
                    System.out.println("2号线程获取了r1的锁");
                }
            }
        }
    }
}
