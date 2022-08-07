package xyz.mengnan.smallspring.beans.factory.support;

import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;

/**
 * 提供了定义Bean模版的能力
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
