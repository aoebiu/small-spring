package xyz.mengnan.smallspring.beans.factory.support;

import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
