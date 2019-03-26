package com.code.jdk.thead;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducer {
    public static final String EXIT_MSG = "Good bye!";
    // 使用较小的队列，以更好地在输出中展示其影响
    public static BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) {
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    static class Producer implements Runnable {
        private BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> q) {
            this.queue = q;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(5L);
                    String msg = "Message" + i;
                    System.out.println("Produced new item: " + msg);
                    queue.put(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println("Time to say good bye!");
                queue.put(EXIT_MSG);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> q) {
            this.queue = q;
        }

        @Override
        public void run() {
            try {
                String msg;
                while (!EXIT_MSG.equalsIgnoreCase((msg = queue.take()))) {
                    System.out.println("Consumed item: " + msg);
                    Thread.sleep(10L);
                }
                System.out.println("Got exit message, bye!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
