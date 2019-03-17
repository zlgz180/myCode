package com.code.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * //
 *
 * @author tianwei
 * @since 2019/3/16 18:34
 */
@Component public class MyFactoryBean implements FactoryBean {

    @Override public Object getObject() throws Exception {
        return null;
    }

    @Override public Class<?> getObjectType() {
        return null;
    }

    @Override public boolean isSingleton() {
        return false;
    }
}
