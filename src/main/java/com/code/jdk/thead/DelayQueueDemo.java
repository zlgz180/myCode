package com.code.jdk.thead;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 延时队列
 * 
 * @author tianwei
 * @since 2019-02-22 10:20
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        DelayQueue<MyDelayMsg> delayeds = new DelayQueue<>();
        delayeds.add(new MyDelayMsg("1", 10000L));
        delayeds.add(new MyDelayMsg("2", 10000L));
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.execute(new Consumer(delayeds));
        threadPool.shutdown();
    }

    static class Consumer implements Runnable {
        // 延时队列 ,消费者从其中获取消息进行消费
        private DelayQueue<MyDelayMsg> queue;

        public Consumer(DelayQueue<MyDelayMsg> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    MyDelayMsg take = queue.take();
                    System.out.println(take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
