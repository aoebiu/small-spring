package xyz.mengnan.smallspring.beans;

/**
 * 注入未被容器维护着的对象
 * 用来注入基本数据类型、对应的包装类、BeanDefinition和BeanReference
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
