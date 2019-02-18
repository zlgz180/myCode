package com.my.code.thead;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 3个线程交替打印123
 * 
 * @author tianwei
 * @since 2018-06-27 15:23
 */
public class ArrayBlockingQueueDemo {
    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1000);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int sum = 0;
            while (true) {
                try {
                    Thread.sleep(100);
                    queue.put(sum++);
                    System.out.println("生产者" + sum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("消费线程" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

}
