package xyz.mengnan.smallspring.beans.factory.config;

/**
 * 这个对象使用需要被封装于PropertyValue中,small-spring容器检测到此处的beanName后会从容器中循环寻找
 * 所以需要先确保容器中已经注入了对应beanName的Bean
 *
 * 这是一个需要从容器中寻找的对象
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}