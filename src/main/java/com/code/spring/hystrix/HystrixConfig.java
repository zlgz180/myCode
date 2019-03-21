package com.code.spring.hystrix;

import org.springframework.context.annotation.Configuration;

/**
 *
 * 
 * 1.启动监控大盘 java -jar -DserverPort=7981 -DbindAddress=localhost
 * standalone-hystrix-dashboard-1.5.6-all.jar
 *
 * 2.浏览器访问大盘 http://localhost:7981/hystrix-dashboard/
 *
 * 3.绑定监控url http://point.man.7fresh.com/hystrix.stream
 * 
 * @author tianwei
 * @since 2019/3/20 10:10
 */
@Configuration
public class HystrixConfig {
    // // 用来拦截处理HystrixCommand注解
    // @Bean
    // public HystrixCommandAspect hystrixAspect() {
    // return new HystrixCommandAspect();
    // }
    //
    // // 用来像监控中心Dashboard发送stream信息
    // @Bean
    // public ServletRegistrationBean hystrixMetricsStreamServlet() {
    // ServletRegistrationBean registration = new ServletRegistrationBean(new
    // HystrixMetricsStreamServlet());
    // registration.addUrlMappings("/hystrix.stream");
    // return registration;
    // }
}
