package xyz.mengnan.smallspring.beans.factory;

import xyz.mengnan.smallspring.beans.BeansException;

/**
 * bean
 *
 * @param
 */
public interface BeanFactory {

    <T> T getBean(String name) throws BeansException;

    <T> T getBean(String name, String... args) throws BeansException;
}
