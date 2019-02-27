package com.my.code.thead;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * 3个线程交替打印123
 * 
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class CyclicBarrierDemo {
    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier lock = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("0了");
                // lock.reset();
            }
        });
        ExecutorService pool = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 5; i++) {
            execute(lock, pool);
        }
        pool.shutdown();
        System.out.println("结束");
    }

    private static void execute(CyclicBarrier lock, ExecutorService pool) {
        pool.submit(() -> {
            try {
                lock.await();
                System.out.println("等待" + lock.getNumberWaiting() + ",part" + lock.getParties());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            longAdder.increment();
            System.out.println(longAdder.sum());
        });
    }

}
