package com.code.jdk.thead;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 启动两个线程, 一个输出 1,3,5,7…99, 另一个输出 2,4,6,8…100 最后 STDOUT 中按序输出 1,2,3,4,5…100
 *
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class SynchronizedDemo2 {
    static Lock lock = new ReentrantLock(); // 可重写锁
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();

    public static void main(String[] args)  {
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        new AThread(key1, key2).start();
        new BThread(key2, key3).start();
        new CThread(key3, key1).start();
    }

    static class AThread extends Thread {
        Object key1;
        Object key2;

        public AThread(Object key1, Object key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "----A");
                    conditionB.signalAll();
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class BThread extends Thread {
        Object key1;
        Object key2;

        public BThread(Object key1, Object key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "----B");
                    conditionC.signalAll();
                    conditionB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class CThread extends Thread {
        Object key1;
        Object key2;

        public CThread(Object key1, Object key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "----C");
                    conditionA.signalAll();
                    conditionC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
