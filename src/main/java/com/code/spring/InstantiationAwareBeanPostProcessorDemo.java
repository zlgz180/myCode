package com.code.spring;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InstantiationAwareBeanPostProcessorDemo implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String service) throws BeansException {
        System.out.println("这里的返回必须为beanafter,bean=" + bean + ",service=" + service);
        return bean;// 这里的返回必须为bean
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String service) throws BeansException {
        System.out.println("这里的返回必须为before,bean=" + bean + ",service=" + service);
        return bean;// 这里的返回必须为bean
    }


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }


    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }


    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
            String beanName) throws BeansException {
        return null;
    }
}
