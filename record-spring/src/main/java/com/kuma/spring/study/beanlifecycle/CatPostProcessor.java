package com.kuma.spring.study.beanlifecycle;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Classname CatPostProcessor
 * @Description：
 * @Date 2019/12/12
 * @Time 15:19
 * @Author ypf
 **/
public class CatPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("---  postProcessBeforeInitialization [before] bean: " + JSON.toJSONString(bean) + " beanName: " + beanName + "  ---");
        if (bean instanceof Cat)
            ((Cat) bean).setAge(2);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("---  postProcessAfterInitialization [after] bean: " + JSON.toJSONString(bean) + " beanName: " + beanName + "  ---");

        if (bean instanceof Cat)
            ((Cat) bean).setName("b");
        return bean;
    }

}
