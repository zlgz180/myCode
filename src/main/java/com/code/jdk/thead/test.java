package com.code.jdk.thead;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main2(String[] args) throws InterruptedException {
        ExecutorService exec = new ThreadPoolExecutor(3, 3, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setUncaughtExceptionHandler((t, e) -> System.out.println("线程异常信息=" + e.fillInStackTrace()));
                    thread.setName("自定义线程池");
                    return thread;
                }, new ThreadPoolExecutor.CallerRunsPolicy());
        Thread.sleep(5000L);
        for (int i = 0; i < 30; i++) {
            Thread.sleep(1000L);
            exec.execute(new MyThread());
        }
        // exec.shutdown();
    }


    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                    if (i == 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("Java技术栈");
                lock.notifyAll();
            }
        });

        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        int[] ints = new int[1024 * 1024 * 10];
        ints[0] = 1;
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ints.length);
    }
}
