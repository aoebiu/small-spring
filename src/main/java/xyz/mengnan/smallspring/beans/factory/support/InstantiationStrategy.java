package xyz.mengnan.smallspring.beans.factory.support;

import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化接口
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args);

}
