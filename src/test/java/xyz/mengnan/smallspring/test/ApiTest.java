package xyz.mengnan.smallspring.test;

import xyz.mengnan.smallspring.test.beans.UserService;
import org.junit.Test;
import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;
import xyz.mengnan.smallspring.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {

    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = beanFactory.getBean("userService", "zhangsan");

        System.out.println("--------------------------------");
        System.out.println(userService.queryUserInfo());
    }
}
