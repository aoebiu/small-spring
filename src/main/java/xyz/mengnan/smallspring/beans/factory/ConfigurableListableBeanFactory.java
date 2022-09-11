package xyz.mengnan.smallspring.beans.factory;

import xyz.mengnan.smallspring.beans.BeansException;
import xyz.mengnan.smallspring.beans.factory.config.AutowireCapableBeanFactory;
import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;
import xyz.mengnan.smallspring.beans.factory.config.ConfigurableBeanFactory;

/**
 * 支持迭代的可配置Bean工厂
 *
 * 除了继承了ConfigurableBeanFactory,分析和修改Bean定义并预实例化单例
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
