package com.code.jdk.thead;

import java.util.Map;
import java.util.concurrent.*;

import com.alibaba.fastjson.JSON;

public class test {
    public static void main4(String[] args) {
        Thread.dumpStack();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        System.out.println(JSON.toJSONString(allStackTraces));

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                new Thread(r).setUncaughtExceptionHandler((t, e) -> {

                });
                return null;
            }
        };
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, 5, 1000L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue(1000), threadFactory, new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    }
                });
    }

    public static void main2(String[] args) throws InterruptedException {

        Thread.yield();
        new Thread().join();
        Object.class.notify();
        Object.class.wait();
        Thread.sleep(1000);
        new Runnable() {
            @Override
            public void run() {

            }
        };
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
            exec.execute(new MyThread("自定义线程" + i));
        }
        // exec.shutdown();
    }

    public static void main3(String[] args) {
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

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = new ThreadPoolExecutor(10, 20, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000),
                new ThreadPoolExecutor.CallerRunsPolicy());
        Thread.sleep(5000L);
        for (int i = 0; i < 30; i++) {
            Thread.sleep(1000L);
            MyThread myThread = new MyThread("自定义线程" + i);
            exec.execute(myThread);
        }
    }
}

class MyThread extends Thread {
    private int[] ints = null;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        ints = new int[1024 * 1024 * 10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "----" + ints[ints.length - 1]);
    }
}
