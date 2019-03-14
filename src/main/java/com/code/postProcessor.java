package com.code;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class postProcessor implements BeanPostProcessor {

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

}
