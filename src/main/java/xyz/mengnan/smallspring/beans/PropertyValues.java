package xyz.mengnan.smallspring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护PropertyValue列表,存储需要实例化Bean的所有元素
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
        return this;
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}

