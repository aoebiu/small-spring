package xyz.mengnan.smallspring.beans.factory.config;

import xyz.mengnan.smallspring.beans.factory.HierarchicalBeanFactory;

/**
 * 可配置的Bean工厂
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
