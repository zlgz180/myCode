package com.code.jdk.thead;

import java.util.concurrent.*;

/**
 * @author tianwei
 * @since 2019-03-27 14:58
 */
public class ThreadpollCancel {
    public static void main(String[] args) {
        ThreadPoolExecutor service = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        Future<Object> submit = service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                return "1";
            }
        });
        Future<Object> submit2 = service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "2";
            }
        });
        try {
            Object o = submit.get(1000, TimeUnit.MILLISECONDS);
            System.out.println("结果=" + o);
        } catch (Exception e) {
            e.printStackTrace();
            boolean cancel = submit.cancel(true);
            System.out.println(cancel);
            System.out.println(submit.isCancelled());
            System.out.println(submit.isDone());
        }

        try {
            Object o = submit2.get(1000, TimeUnit.MILLISECONDS);
            System.out.println("2结果=" + o);
        } catch (Exception e) {
            e.printStackTrace();
            boolean cancel = submit.cancel(true);
            System.out.println(cancel);
            System.out.println(submit.isCancelled());
            System.out.println(submit.isDone());
        }
        System.out.println(service.getCompletedTaskCount());
    }
}
