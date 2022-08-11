package xyz.mengnan.smallspring.beans.factory.support;

import xyz.mengnan.smallspring.beans.BeansException;
import xyz.mengnan.smallspring.beans.PropertyValue;
import xyz.mengnan.smallspring.beans.PropertyValues;
import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;
import xyz.mengnan.smallspring.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args != null ? args : new Object[0]);
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    @Deprecated
    protected Object createBeanInstance(BeanDefinition beanDefinition, Object[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object bean = null;
        Constructor<?>[] declaredConstructors = beanDefinition.getBeanClass().getDeclaredConstructors();

        Constructor<?> constructor = null;
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (null != args && declaredConstructor.getParameterCount() == args.length) {
                constructor = declaredConstructor;
                break;
            }
        }
        if (constructor == null) {
            bean = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
        } else {
            bean = constructor.newInstance(args);
        }

        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor<?> constructor : declaredConstructors) {
            if (constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                // 如果继承BeanReference,则说明注入的也是一个Bean,从容器中获取
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // cglib是通过创建子类来实现代理的,要获取成员变量需要拿到父类
                Field field = bean.getClass().getSuperclass().getDeclaredField(name);
                field.setAccessible(true);
                field.set(bean, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    protected InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }

}
