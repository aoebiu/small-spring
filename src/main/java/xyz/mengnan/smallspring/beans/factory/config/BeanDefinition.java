package xyz.mengnan.smallspring.beans.factory.config;

@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        setBeanClass(beanClass);
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        if (beanClass == null)
            throw new NullPointerException();
        this.beanClass = beanClass;
    }
}
