package com.my.code.jdk.hystrix;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author tianwei
 * @since 2019-02-26 9:31
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")); // 必须
        this.name = name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommandHelloWorld demo = new CommandHelloWorld("tianwei");
         String execute = demo.execute();// 同步调用
        Future<String> queue = demo.queue();// 异步调用
        String s = queue.get();
        System.out.println(s);
    }

    @Override
    protected String run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * 网络调用 或者其他一些业务逻辑，可能会超时或者抛异常
         */
        return "Hello " + name + "!";
    }
}
