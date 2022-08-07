package xyz.mengnan.smallspring.test;

import org.junit.Before;
import xyz.mengnan.smallspring.beans.PropertyValue;
import xyz.mengnan.smallspring.beans.PropertyValues;
import xyz.mengnan.smallspring.beans.factory.config.BeanReference;
import xyz.mengnan.smallspring.test.beans.UserDao;
import xyz.mengnan.smallspring.test.beans.UserService;
import org.junit.Test;
import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;
import xyz.mengnan.smallspring.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {

    DefaultListableBeanFactory beanFactory;

    @Before
    public void init() {
        beanFactory = new DefaultListableBeanFactory();
    }

    /**
     * 有参构造方法测试
     */
    @Test
    public void parameterConstructors() {
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = beanFactory.getBean("userService", "lisi", "2", new UserDao());

        System.out.println("--------------------------------");
        System.out.println(userService.queryUserInfo());
    }

    /**
     * 无参构造方法测试
     */
    @Test
    public void parameterlessConstructor() {
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = beanFactory.getBean("userService");

        System.out.println("--------------------------------");
        System.out.println(userService.queryUserInfo());
    }

    /**
     * BeanDefinition注入测试
     */
    @Test
    public void beanReference() {
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues()
                .addPropertyValue(new PropertyValue("name", "黄九"))
                .addPropertyValue(new PropertyValue("uid", "1"))
                .addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        System.out.println("--------------------------------");
        // 没有传递args使用无参构造方法创建,然后通过applyPropertyValues将bean容器依次注入
        UserService userService = beanFactory.getBean("userService");
        System.out.println(userService.queryUserInfo());
    }
}
