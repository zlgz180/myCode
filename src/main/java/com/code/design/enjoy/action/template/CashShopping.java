package com.code.design.enjoy.action.template;

import java.util.List;

import com.code.design.enjoy.entity.Fruit;

/**
 * 模板方法模式 购物车费用结算过程
 */
public class CashShopping extends ShoppingCart {

    public CashShopping(List<Fruit> products) {
        super(products);
    }

    @Override
    protected void pay(int money) {
        System.out.println("现金结算，假一罚十");
    }
}
