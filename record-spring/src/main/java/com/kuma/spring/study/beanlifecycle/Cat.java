package com.kuma.spring.study.beanlifecycle;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cat implements
        BeanNameAware, // 让Bean获取自己在BeanFactory中的名字
        BeanFactoryAware, // 设置Bean所在的BeanFactory
        ApplicationContextAware, // 设置ApplicationContext
        InitializingBean, // 回调afterPropertiesSet()方法
        DisposableBean { // 回调该接口的destroy()方法

    private String name = "a";

    private int age = 1;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("---  setBeanFactory: " + JSON.toJSONString(beanFactory) + "  ---");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("---  setBeanName: " + s + "  ---");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("---  destroy  ---");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---  afterPropertiesSet  ---");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("---  setApplicationContext: " + JSON.toJSONString(applicationContext) + "  ---");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void myDestory() {
        System.out.println("---  myDestory  ---");
    }

    public void myInit() {
        System.out.println("---  myInit  ---");
        this.age = 100;
    }
}
