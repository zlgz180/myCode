package com.code.jdk.thead;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * 3个线程交替打印123
 *
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class CountDownLatchDemo {
    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        ExecutorService pool = Executors.newFixedThreadPool(6);
        // for (int i = 0; i < 7; i++) {
        // pool.submit(() -> {
        // latch.countDown();
        // longAdder.increment();
        // System.out.println(longAdder.sum());
        // });
        // }

        pool.submit(() -> {
            latch.countDown();
            longAdder.increment();
            System.out.println(longAdder.sum());
        });
        pool.submit(() -> {
            latch.countDown();
            longAdder.increment();
            System.out.println(longAdder.sum());
        });
        // 已经是0了,就不会阻塞
        pool.submit(() -> {
            latch.countDown();
            longAdder.increment();
            System.out.println(longAdder.sum());
        });
        latch.await();
        System.out.println("结束");
        pool.shutdown();
    }

}
