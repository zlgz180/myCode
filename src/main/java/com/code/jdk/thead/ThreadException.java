package com.code.jdk.thead;

/**
 * @author tianwei
 * @since 2019-10-25 11:24 上午
 */
public class ThreadException {
    public static void main(String[] args) {
        System.out.println("线程开始");
        long l = System.currentTimeMillis();
        Thread thread = null;
        try {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程执行完成");
                    int i = 1 / 0;
                }
            });
        } catch (Throwable e) {
            System.out.println("子线程异常" + e.getMessage());
        }
        thread.run();
        System.out.println("耗时" + (System.currentTimeMillis() - l));
    }
}
