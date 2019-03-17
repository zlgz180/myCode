package com.code.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean的前置处理器后置处理器
 *
 * @author tianwei
 * @since 2019/3/16 17:39
 */
@Component public class MyPostProcessor implements BeanPostProcessor {

    @Override public Object postProcessAfterInitialization(Object bean, String service) throws BeansException {
        System.out.println("这里的返回必须为beanafter,bean=" + bean + ",service=" + service);
        return bean;// 这里的返回必须为bean
    }

    @Override public Object postProcessBeforeInitialization(Object bean, String service) throws BeansException {
        System.out.println("这里的返回必须为before,bean=" + bean + ",service=" + service);

        return bean;// 这里的返回必须为bean
    }

}
