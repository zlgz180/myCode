package com.code.jdk.hystrix;

import java.util.concurrent.ExecutionException;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

/**
 * @author tianwei
 * @since 2019-02-26 9:31
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        // super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetProductInfoGroup")));
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetProductInfoGroup"))
                // 设置当前command的key,默认值为当前类名
                .andCommandKey(HystrixCommandKey.Factory.asKey("GetProductInfoCommand"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        // 控制是否要打开timeout机制，默认是true
                        .withExecutionTimeoutEnabled(true)
                        // 手动设置timeout超时时间，一个command运行超出这个时间，就被认为是timeout，然后将hystrix
                        // command标识为timeout，同时执行fallback降级逻辑，默认是1000，也就是1000毫秒
                        .withExecutionTimeoutInMilliseconds(400)
                        // 设置一个rolling window，滑动窗口中，最少要有多少个请求时，才触发开启短路
                        .withCircuitBreakerRequestVolumeThreshold(30)
                        // 设置异常请求量的百分比，当异常请求达到这个百分比时，就触发打开短路器，默认是50，也就是50%
                        .withCircuitBreakerErrorThresholdPercentage(40)
                        // 设置在短路之后，需要在多长时间内直接reject请求，然后在这段时间之后，再重新导holf-open状态，尝试允许请求通过以及自动恢复，默认值是5000毫秒
                        .withCircuitBreakerSleepWindowInMilliseconds(3000)
                        // 使用信号量隔离时，命令调用最大的并发数,默认:10
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(30))
                // 如果不想直接用command group，也可以手动设置thread pool name,细分线程池
                // 一个CommandGroup可以有多个线程池进行内部资源隔离
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("GetProductInfoPool"))
                // 设置当前command对应的线程池的大小和等待队列的大小，但是在信号量模式不适用!!!!
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(15)// 默认值是10
                        // 默认值是5
                        .withMaxQueueSize(10)));
        HystrixRequestContext.initializeContext();
        this.name = name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommandHelloWorld demo = new CommandHelloWorld("tianwei");
        System.out.println("开始");
        String execute = demo.execute();// 同步调用
        // Future<String> queue = demo.queue();// 异步调用
        // String execute = queue.get();
        System.out.println(execute);
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

    @Override
    protected String getFallback() {
        System.out.println("服务降级");
        // return super.getFallback();
        return "tianwei";
    }

    @Override
    protected String getCacheKey() {
        return name + 111;
    }

     
}
