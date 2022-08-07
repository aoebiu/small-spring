package xyz.mengnan.smallspring.beans.factory.support;

import xyz.mengnan.smallspring.beans.BeansException;
import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) {
        Class<?> clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }
            return clazz.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            throw new BeansException("Failed to instantiate '" + clazz.getName() + "；", e);
        }
    }

}