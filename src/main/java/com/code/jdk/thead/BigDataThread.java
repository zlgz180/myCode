package com.code.jdk.thead;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tianwei
 * @since 2019-07-07 23:27
 */
public class BigDataThread {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(50, 50, 1000L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue(1000), r -> {
                    Thread thread = new Thread(r);
                    thread.setName("tianwei");
                    return thread;
                });

        for (int i = 0; i < 10; i++) {
            TestThread testThread = new TestThread();
            testThread.setName("i");
            poolExecutor.execute(testThread);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TestThread extends Thread {
        public TestThread() {
        }

        @Override
        public void run() {
            int[][] data = new int[1024][1024];
        }
    }
}
