package com.my.code.thead;

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
        ArrayList<Object> list = new ArrayList<>();
        Date date = new Date();
        delayeds.add(new MyDelayMsg("1", 10000L));
        delayeds.add(new MyDelayMsg("2", 10000L));
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.execute(new Consumer(delayeds));
        threadPool.shutdown();
    }

    static class MyDelayMsg implements Delayed {
        private final long delayTime; // 延迟时间
        private final long expire; // 到期时间
        private Object data; // 数据

        public MyDelayMsg() {
            delayTime = 0;
            expire = 0;
        }

        public MyDelayMsg(Object data, long delay) {
            delayTime = delay;
            this.data = data;
            expire = System.currentTimeMillis() + delay;
        }


        /**
         * 方法返回该元素距离失效还剩余的时间，当<=0时元素就失效了， 就可以从队列中获取到。
         * 
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "MyDelayMsg{" + "delayTime=" + delayTime + ", expire=" + expire + ", data=" + data + '}';
        }
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
