package com.code.jdk.thead;

import java.util.concurrent.*;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * 线程间异常捕获问题
 * 
 * @author tianwei
 * @since 2018-06-27 10:34
 */
public class ThreadPoolExceptionDemo {

    public static void main(String[] args)  {
        // try {
        // DivTask divTask = new DivTask(99, 0);
        // new Thread(divTask).start();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        ThreadFactory executorThreadFactory = new BasicThreadFactory.Builder().namingPattern("task-scanner-executor-%d")
                .uncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("3323" + e.fillInStackTrace());
                    }
                }).build();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 10, 0, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), executorThreadFactory);
        for (int i = 0; i < 3; i++) {
            // 无法打印堆栈信息
            // threadPool.submit(new DivTask(99, i));
            threadPool.execute(new DivTask(99, i));
            Future<?> submit = threadPool.submit(new Runnable() {
                @Override public void run() {

                }
            });
            try {
                submit.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            // Future可以捕获堆栈溢出
            // Future<?> submit = threadPool.submit(new DivTask(99, i));
            // try {
            // submit.get();
            // } catch (Exception e) {
            // e.printStackTrace();
            // }
        }
    }
}

// 工作线程，执行除法操作
class DivTask implements Runnable, Thread.UncaughtExceptionHandler {
    private int number, division;

    public DivTask(int number, int division) {
        this.number = number;
        this.division = division;
    }

    @Override
    public void run() {
        // System.out.println(number / division);
        throw new RuntimeException("dddd");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(e.fillInStackTrace());
    }
}

