package xyz.mengnan.smallspring.beans.factory.support;

import net.sf.cglib.proxy.*;
import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());

        enhancer.setCallback((MethodInterceptor) (obj, method, a, proxy) -> {
            return proxy.invokeSuper(obj, a);
        });
        if (null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
