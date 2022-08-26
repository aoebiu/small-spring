package xyz.mengnan.smallspring.test;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import xyz.mengnan.smallspring.beans.factory.support.DefaultListableBeanFactory;
import xyz.mengnan.smallspring.beans.factory.xml.DefaultDocumentLoader;
import xyz.mengnan.smallspring.beans.factory.xml.XmlBeanDefinitionReader;
import xyz.mengnan.smallspring.core.io.DefaultResourceLoader;
import xyz.mengnan.smallspring.core.io.Resource;
import xyz.mengnan.smallspring.test.beans.UserService;

import java.io.InputStream;

public class ConfigTest {

    DefaultResourceLoader resourceLoader;
    DefaultListableBeanFactory beanFactory;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
        beanFactory = new DefaultListableBeanFactory();
    }

    /**
     * xml读取测试
     */
    @Test
    public void loadXml() throws Exception {
        Resource resource = resourceLoader.getResource("classpath:small-spring.xml");
        InputStream inputStream = resource.getInputStream();
        Document content = new DefaultDocumentLoader().loadDocument(inputStream);
        Element root = content.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        System.out.println("--------------------------------");
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            System.out.println("id: " + id + " name: " + name + "className: " + className);
        }
    }

    /**
     * Xml配置文件导入测试
     */
    @Test
    public void definition() {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:small-spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);

        System.out.println("--------------------------------");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
