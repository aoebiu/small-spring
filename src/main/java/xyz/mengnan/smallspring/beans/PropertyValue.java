package xyz.mengnan.smallspring.beans;

/**
 * 注入未被容器维护着的对象,一般用来注入基本数据类型以及对应的包装类
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
