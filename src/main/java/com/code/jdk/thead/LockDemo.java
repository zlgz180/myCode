package com.code.jdk.thead;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tianwei
 * @since 2019-03-25 23:05
 */
public class LockDemo {
    public static void main(String[] args) {
        AbstractQueuedSynchronizer aqs = new AbstractQueuedSynchronizer() {
            @Override protected boolean tryAcquire(int arg) {
                return super.tryAcquire(arg);
            }
        };

        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();



    }
}
