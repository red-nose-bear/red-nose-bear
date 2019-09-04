package com.kuma.spring.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

/**
 * 获取spring上下文，根据beanName获取容器中的bean
 */
@Component
public class SpringUtil extends ApplicationObjectSupport {

    /**
     * spring容器
     */
    private static ApplicationContext applicationContext;

    /**
     * 根据beanName获取bean
     * 调用者注意 可能抛出的异常：
     * IllegalArgumentException - 传入的beanName为null
     * NoSuchBeanDefinitionException - 容器中没有对应的bean
     */
    public static final Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    @Override
    protected void initApplicationContext(ApplicationContext context) throws BeansException {
        super.initApplicationContext();
        SpringUtil.applicationContext = context;
    }
}