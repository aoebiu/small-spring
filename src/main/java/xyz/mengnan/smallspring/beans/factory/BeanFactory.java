package xyz.mengnan.smallspring.beans.factory;

import xyz.mengnan.smallspring.beans.BeansException;

/**
 * 提供了获取Bean工厂的能力
 */
public interface BeanFactory {

    <T> T getBean(String name) throws BeansException;

    <T> T getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
