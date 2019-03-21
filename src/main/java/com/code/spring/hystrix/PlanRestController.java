package com.code.spring.hystrix;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 积分计划相关api
 *
 * @author tianwei
 * @since 2017/8/3 11:42
 */
@RestController
@RequestMapping("/api/plan")
public class PlanRestController {
    private static final String APP_NAME = "会员营销系统";
    private static final Pattern MOBILE_PATTERN = Pattern.compile("1[0-9]{10}");
    private static AtomicInteger sum = new AtomicInteger(0);
//    @Resource
//    private PointPlanProviderHelper planRpc;
//
//    @HystrixCommand(fallbackMethod = "getOrderPageListFallback", threadPoolProperties = { // 10个核心线程池,超过20个的队列外的请求被拒绝;当一切都是正常的时候，线程池一般仅会有1到2个线程激活来提供服务
//            @HystrixProperty(name = "coreSize", value = "10"), @HystrixProperty(name = "maxQueueSize", value = "5"),
//            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20") }, commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "900"), // 命令执行超时时间
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"), // 若干10s一个窗口内失败三次,则达到触发熔断的最少请求量
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000") // 断路30s后尝试执行,默认为5s
//    })
//    @RequestMapping(value = "/getOrderPageList")
//    public Response<Boolean> getOrderPageList(Long id) throws InterruptedException {
//        Random random = new Random();
//        long l = random.nextInt(2000) + 1;
//        log.info(l + "查询缓存超时" + sum.incrementAndGet());
//        // Thread.sleep(l);
//        if (l > 1000) {
//            // int i = 1 / 0;
//        }
//        // do something
//        return ResponseUtil.paramError("成功");
//    }
//
//    public Response<Boolean> getOrderPageListFallback(Long id) {
//        log.error("===================== 执行降级策略");
//        // 发mq丢出去
//        return ResponseUtil.paramError("降级处理");
//    }
}
