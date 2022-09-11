package xyz.mengnan.smallspring.beans.factory;

import xyz.mengnan.smallspring.beans.BeansException;

import java.util.Map;

/**
 * 支持迭代容器中的类模版对象
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
