package xyz.mengnan.smallspring.beans;

/**
 * 注入需要实例化容器的对应的一个元素
 * 用来注入基本数据类型、对应的包装类、
 * BeanDefinition {@link xyz.mengnan.smallspring.beans.factory.config.BeanDefinition}
 * 和 BeanReference {@link xyz.mengnan.smallspring.beans.factory.config.BeanReference}
 */
public class PropertyValue {

    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
