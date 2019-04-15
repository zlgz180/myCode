package com.code.design.enjoy.entity;

import com.code.design.enjoy.action.visit.Visit;

/**
 * 水果接口
 */
public interface Fruit {

    int price();

    void draw();

    int accept(Visit visit);

}
