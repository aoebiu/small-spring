package xyz.mengnan.smallspring.beans.factory.support;

import xyz.mengnan.smallspring.beans.BeansException;
import xyz.mengnan.smallspring.beans.factory.BeanFactory;
import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;

/**
 * 提供了获取Bean模版的能力和通过模版实例化Bean的能力
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public <T> T getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public <T> T getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBean(name);
    }

    @SuppressWarnings({"unchecked"})
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

}
