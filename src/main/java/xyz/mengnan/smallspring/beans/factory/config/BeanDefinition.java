package xyz.mengnan.smallspring.beans.factory.config;

import xyz.mengnan.smallspring.beans.PropertyValues;

/**
 * 通过propertyValues来注入对象,起到类似构造方法注入同等的效果
 */
public class BeanDefinition {
    // 类模版对象
    private Class<?> beanClass;
    // 实例化后需要传递进类模版对象的列表
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        setBeanClass(beanClass);
        setPropertyValues(propertyValues);
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        if (beanClass == null)
            throw new NullPointerException();
        this.beanClass = beanClass;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
