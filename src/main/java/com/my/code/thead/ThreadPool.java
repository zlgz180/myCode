package com.my.code.thead;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

/**
 * @author tianwei
 * @since 2018-06-27 10:34
 */
public class ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 5, 1000, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<Runnable>(200), new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, java.util.concurrent.ThreadPoolExecutor executor) {

                    }
                });

        List<Runnable> runnables = poolExecutor.shutdownNow();
    }
}
