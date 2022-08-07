package xyz.mengnan.smallspring.beans.factory.config;

/**
 * 实现该接口注入单例容器
 * 容器内元素维护在singletonObjects中
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
