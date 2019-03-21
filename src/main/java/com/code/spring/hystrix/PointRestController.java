package com.code.spring.hystrix;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 积分计划相关api
 *
 * @author tianwei
 * @since 2017/8/3 11:42
 */
@RestController
@RequestMapping("/api/point")
public class PointRestController   {
    @Resource
    private PlanRestController planRestController;

//    @RequestMapping(value = "/test")
//    public Response<Boolean> test(Long id) throws InterruptedException {
//        Response<Boolean> orderPageList = planRestController.getOrderPageList(id);
//        log.info("操作2");
//        return orderPageList;
//    }



}
