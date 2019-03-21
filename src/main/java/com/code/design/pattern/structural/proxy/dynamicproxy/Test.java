package com.code.design.pattern.structural.proxy.dynamicproxy;

import com.code.design.pattern.structural.proxy.IOrderService;
import com.code.design.pattern.structural.proxy.Order;
import com.code.design.pattern.structural.proxy.OrderServiceImpl;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        // order.setUserId(2);
        order.setUserId(1);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl())
                .bind();

        orderServiceDynamicProxy.saveOrder(order);
    }
}
